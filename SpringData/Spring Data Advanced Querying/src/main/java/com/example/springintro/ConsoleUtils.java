package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleUtils {

    private final CategoryService categoryService;
        private final AuthorService authorService;
        private final BookService bookService;
        private Scanner scan;



    public ConsoleUtils(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;

    }

    public void goldenBooksWithLess5000Copies() {
         List<Book> goldenBooks = this.bookService.
                findBookByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000);
        goldenBooks.stream().map(Book::getTitle).forEach(System.out::println);
    }

    public void bookByGivenAgeRestriction() {
        String input = scan.nextLine();
        AgeRestriction ageRestriction = AgeRestriction.valueOf(input.toUpperCase());
        List<Book> bookByAgeRestriction = this.bookService.findBookByAgeRestriction(ageRestriction);
        bookByAgeRestriction.stream().map(b -> b.getTitle()).forEach(b -> System.out.println(b));
    }

    public void lessOrGreaterPriceOfBook() {
        List<Book> lessGreaterPriceBooks = this.bookService.findBookByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40));

        lessGreaterPriceBooks.forEach(b -> System.out.printf("%s - $%.2f%n", b.getTitle(), b.getPrice()));
    }

    private void bookNotReleasedInThatYear() {
        int year = Integer.parseInt(scan.nextLine());
        List<Book> booksNotInTheYear = this.bookService
                .findBookByReleaseDateIsNot(LocalDate.of(year,1,1));

        booksNotInTheYear.stream().map(Book::getTitle).forEach(System.out::println);
    }


    public void booksByReleasedDateBefore() {
        String[] data = scan.nextLine().split("-");
        int day = Integer.parseInt(data[0]);
        int month = Integer.parseInt(data[1]);
        int year = Integer.parseInt(data[2]);

        List<Book> allByReleaseDateBefore = this.bookService.findAllByReleaseDateBefore(LocalDate.of(year, month, day));

        allByReleaseDateBefore.forEach(b -> System.out.printf("%s %s %.2f%n"
                , b.getTitle(), b.getEditionType(), b.getPrice()));
    }

    public void authorsFirstNameEndingWith() {
        String inputText = scan.nextLine();
        List<Author> nameEndingWith = this.authorService.findAuthorByFirstNameEndingWith(inputText);

        nameEndingWith.forEach(a -> System.out.printf("%s %s%n", a.getFirstName(), a.getLastName()));
    }

    public void bookSearch() {
        String input = scan.nextLine();

        List<Book> bookByTitleContains = this.bookService.findBookByTitleContains(input);

        bookByTitleContains.stream().map(Book::getTitle).forEach(System.out::println);
    }

    public void bookTitleSearch() {
        String input = scan.nextLine();
        List<Book> lastNameStartingWith = this.bookService.findAllByAuthorLastNameStartingWith(input);
        lastNameStartingWith.stream().map(Book::BookTitleAndAuthorsNames).forEach(System.out::println);
    }

    public void countBooks() {
        int number = Integer.parseInt(scan.nextLine());

        System.out.println(this.bookService.findBookCount(number));
    }

    public void reducedBook() {
        String inputTitle = scan.nextLine();
        Book book = this.bookService.BookByTitle(inputTitle);
        System.out.println(book);
    }
}
