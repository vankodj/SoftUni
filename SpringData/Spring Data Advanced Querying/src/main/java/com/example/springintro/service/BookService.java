package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.model.entity.dto.BookInformation;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

//    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<Book> findBookByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findBookByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    List<Book> findBookByPriceLessThanOrPriceGreaterThan
            (BigDecimal lowerPrice,BigDecimal greaterPrice);

    List<Book> findBookByReleaseDateIsNot(LocalDate date);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findBookByTitleContains(String text);

    List<Book> findAllByAuthorLastNameStartingWith(String text);

    Integer findBookCount(Integer number);

    Book BookByTitle(String title);

}
