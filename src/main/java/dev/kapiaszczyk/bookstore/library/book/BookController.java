package dev.kapiaszczyk.bookstore.library.book;

import dev.kapiaszczyk.bookstore.library.inventory.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public ResponseEntity<Iterable<BookDTO>> getAllBooks() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/title-isbn-authors")
    public ResponseEntity<Iterable<BookInformationProjection>> findAllBooksWithTitleIsbnAuthors() {
        return new ResponseEntity<>(bookService.getAllBooksWithTitleIsbnAuthors(), HttpStatus.OK);
    }

    @GetMapping("/title/{title}/library/{name}")
    public ResponseEntity<Iterable<BookDTO>> getBooksByTitleAndInventoryLibraryName(@PathVariable String title, @PathVariable String name) {
        return new ResponseEntity<>(bookService.getBooksByTitleAndInventoryLibraryName(title, name), HttpStatus.OK);
    }


}