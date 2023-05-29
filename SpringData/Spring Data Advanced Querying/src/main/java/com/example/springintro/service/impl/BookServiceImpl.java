package com.example.springintro.service.impl;

import com.example.springintro.model.entity.*;
import com.example.springintro.model.entity.dto.BookInformation;
import com.example.springintro.repository.BookRepository;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository
                .findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }


    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {
       return bookRepository
                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream()
                .map(book -> String.format("%s %s %d",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findBookByAgeRestriction(AgeRestriction ageRestriction) {
        return bookRepository.findBookByAgeRestriction(ageRestriction)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Book> findBookByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies) {
        return this.bookRepository.findBookByEditionTypeAndCopiesLessThan(editionType,copies)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Book> findBookByPriceLessThanOrPriceGreaterThan(BigDecimal lowerPrice,BigDecimal greaterPrice) {
        return this.bookRepository.findBookByPriceLessThanOrPriceGreaterThan(lowerPrice,greaterPrice)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Book> findBookByReleaseDateIsNot(LocalDate date) {
        return this.bookRepository.findBookByReleaseDateIsNot(date)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore) {
        return bookRepository.findAllByReleaseDateBefore(releaseDateBefore)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Book> findBookByTitleContains(String text) {
        return this.bookRepository.findBookByTitleContains(text.toUpperCase())
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Book> findAllByAuthorLastNameStartingWith(String text) {
        return this.bookRepository.findAllByAuthorLastNameStartingWith(text)
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Integer findBookCount(Integer number) {
        return this.bookRepository.findBookCount(number).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Book BookByTitle(String title) {
        return bookRepository.findFirstByTitle(title).orElseThrow(NoSuchElementException::new);
    }


    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate
                .parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService
                .getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

    }
}
