package ua.lviv.sombra.service;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.sombra.entiry.Book;
import ua.lviv.sombra.repository.AuthorRepository;
import ua.lviv.sombra.repository.BookRepository;
import ua.lviv.sombra.service.dto.BookDto;
import ua.lviv.sombra.service.mapper.BookMapper;

@Service
public class BookService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void createBook(BookDto bookDto) {
        bookRepository.save(BookMapper.instance.bookDtoToBook(bookDto));
    }

    @Transactional
    public void deleteBook(Long idBook) {
        bookRepository.deleteById(idBook);
    }

    @Transactional
    public BookDto findBookDtoById(Long idBook) {
        Book book = bookRepository.findById(idBook).orElseThrow(() ->
                new ResourceNotFoundException("Book not found"));
        return BookMapper.instance.bookToBookDto(book);
    }

    @Transactional
    public BookDto updateBook(BookDto bookDto) {
        Book book = bookRepository.findById(bookDto.getId()).orElseThrow(() ->
                new ResourceNotFoundException("Book not found"));
        bookRepository.saveAndFlush(BookMapper.instance.bookDtoToBook(bookDto));
        return findBookDtoById(book.getId());
    }

}
