package bg.softuni.booksserver.service;

import bg.softuni.booksserver.model.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface BookService {
    List<BookDTO> getAllBooks();
   Optional<BookDTO> findBookById(Long id);

   void deleteBookById(Long id);
}
