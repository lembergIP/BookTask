package ua.lviv.sombra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.sombra.service.AuthorService;
import ua.lviv.sombra.service.dto.AuthorDto;

import java.util.Set;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto) {
        authorService.createAuthor(authorDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{authorId}")
    public AuthorDto getAuthor(@PathVariable Long authorId) {
        return authorService.findAuthorDtoById(authorId);
    }

    @DeleteMapping("/{authorId}")
    public void deleteAuthor(@PathVariable Long authorId) {
        authorService.deleteAuthor(authorId);
    }

    @PutMapping
    public AuthorDto updateAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.updateAuthor(authorDto);
    }

    @PutMapping("/{authorId}/book/{bookId}")
    public ResponseEntity<AuthorDto> addBookToAuthor(@PathVariable Long authorId, @PathVariable Long bookId) {
        authorService.addBookToAuthor(authorId, bookId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{authorId}/book/{bookId}")
    public ResponseEntity<AuthorDto> deleteBookFromAuthor(@PathVariable Long authorId, @PathVariable Long bookId) {
        authorService.deleteBookFromAuthor(authorId, bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/olderThan/{age}")
    public Set<AuthorDto> getAuthorsOlderThan(@PathVariable Integer age){
        return authorService.getAuthorsOlderThan(age);
    }

    @GetMapping("/bookNumber/most")
    public Set<AuthorDto> getAuthorsByMostNumberOfBooks(){
        return authorService.getAuthorsByMostNumberOfBooks();
    }
    
}
