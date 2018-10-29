package ua.lviv.sombra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.sombra.service.BookService;
import ua.lviv.sombra.service.dto.BookDto;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookDto> createAuthor(@RequestBody BookDto bookDto) {
        bookService.createBook(bookDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{bookId}")
    public BookDto getAuthor(@PathVariable Long bookId) {
        return bookService.findBookDtoById(bookId);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
    }

    @PutMapping
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        return bookService.updateBook(bookDto);
    }
}
