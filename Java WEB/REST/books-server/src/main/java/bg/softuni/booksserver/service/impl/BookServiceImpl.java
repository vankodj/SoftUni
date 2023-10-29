package bg.softuni.booksserver.service.impl;

import bg.softuni.booksserver.model.dto.AuthorDTO;
import bg.softuni.booksserver.model.dto.BookDTO;
import bg.softuni.booksserver.model.entity.BookEntity;
import bg.softuni.booksserver.repo.BookRepository;
import bg.softuni.booksserver.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookServiceImpl::mapBookToDTO)
                .toList();
    }

    @Override
    public Optional<BookDTO> findBookById(Long id) {
        return bookRepository.findById(id)
                .map(BookServiceImpl::mapBookToDTO);
    }

    @Override
    public void deleteBookById(Long id) {
     this.bookRepository.deleteById(id);
    }


    private static BookDTO mapBookToDTO(BookEntity bookEntity){
        AuthorDTO authorDTO = new AuthorDTO().setName(bookEntity.getAuthor().getName());

  return new BookDTO()
           .setId(bookEntity.getId())
           .setIsbn(bookEntity.getIsbn())
           .setTitle(bookEntity.getTitle())
           .setAuthor(authorDTO);

    }
}
