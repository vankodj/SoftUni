package bg.softuni.booksserver.web;

import bg.softuni.booksserver.model.dto.BookDTO;
import bg.softuni.booksserver.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BooksRestController {

    private final BookService bookService;

    public BooksRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks(){
   return ResponseEntity.ok(bookService.getAllBooks());
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO>findBookById(@PathVariable("id") Long id){
        Optional<BookDTO> bookDTOOptional = bookService.findBookById(id);

        return bookDTOOptional.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookDTO> deleteBookById(@PathVariable ("id") Long id){
    bookService.deleteBookById(id);
    return ResponseEntity.noContent().build();
    }
}
