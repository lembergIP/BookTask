package ua.lviv.sombra.service;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.sombra.entiry.Author;
import ua.lviv.sombra.entiry.Book;
import ua.lviv.sombra.repository.AuthorRepository;
import ua.lviv.sombra.repository.BookRepository;
import ua.lviv.sombra.service.dto.BookDto;
import ua.lviv.sombra.service.mapper.BookMapper;

import java.util.HashSet;
import java.util.Set;

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
    public boolean deleteAuthorFromBook(Long book_id, Long author_id) {
        Book book = findBookById(book_id);
        Author author = authorRepository.findById(author_id).orElseThrow(() ->
                new ResourceNotFoundException("Author not found"));
        book.getAuthors().removeIf(a -> a.equals(author));
        bookRepository.saveAndFlush(book);
        return true;
    }

    @Transactional
    public BookDto findBookDtoById(Long book_id) {
        Book book = findBookById(book_id);
        return BookMapper.instance.bookToBookDto(book);
    }

    @Transactional
    public BookDto updateBook(BookDto bookDto) {
        Book book = bookRepository.findById(bookDto.getId()).orElseThrow(() ->
                new ResourceNotFoundException("Book not found"));
        bookRepository.saveAndFlush(BookMapper.instance.bookDtoToBook(bookDto));
        return findBookDtoById(book.getId());
    }

    @Transactional
    public Set<BookDto> getAllBooksDto(){
        return BookMapper.instance.listBookToListBookDto(new HashSet<>(bookRepository.findAll()));
    }

    @Transactional
    public boolean addAuthorToBook(Long book_id, Long author_id) {
        Book book = findBookById(book_id);
        Author author = authorRepository.findById(author_id).orElseThrow(() ->
                new ResourceNotFoundException("Author not found"));
        book.getAuthors().add(author);
        bookRepository.saveAndFlush(book);
        return true;
    }

    @Transactional
    public Book findBookById(Long book_id) {
        return bookRepository.findById(book_id).orElseThrow(() ->
                new ResourceNotFoundException("Book not found"));
    }

    @Transactional
    public int countBooksByGenre(String genre) {
        return bookRepository.countBooksByGenre(genre);
    }

    @Transactional
    public Set<BookDto> getBooksByAuthorNumberOfBooksMoreThan(Long number) {
        Set<Book> books = new HashSet<>();
        bookRepository.findAll().forEach(book -> {if (book.getAuthors().size() > number) { books.add(book);}});
        return BookMapper.instance.listBookToListBookDto(books);
    }
}
