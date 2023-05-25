package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.model.entity.dto.BookInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    Optional<List<Book>> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    Optional<List<Book>> findBookByAgeRestriction(AgeRestriction ageRestriction);

    Optional<List<Book>> findBookByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    Optional<List<Book>> findBookByPriceLessThanOrPriceGreaterThan
            (BigDecimal lowerPrice,BigDecimal greaterPrice);

    Optional<List<Book>> findBookByReleaseDateIsNot(LocalDate date);

    Optional<List<Book>> findBookByTitleContains(String text);

    Optional<List<Book>> findAllByAuthorLastNameStartingWith(String text);

    @Query ("select count(b) from Book as b where length(b.title) >  :number")
    Optional<Integer> findBookCount(Integer number);


   

    Optional<Book> findFirstByTitle(String title);







}
