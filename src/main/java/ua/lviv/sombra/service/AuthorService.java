package ua.lviv.sombra.service;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.sombra.entiry.Author;
import ua.lviv.sombra.entiry.Book;
import ua.lviv.sombra.repository.AuthorRepository;
import ua.lviv.sombra.repository.BookRepository;
import ua.lviv.sombra.service.dto.AuthorDto;
import ua.lviv.sombra.service.mapper.AuthorMapper;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void createAuthor(AuthorDto authorDto) {
        authorRepository.save(AuthorMapper.instance.authorDtoToAuthor(authorDto));
    }

    @Transactional
    public void deleteAuthor(Long idAuthor) {
        authorRepository.deleteById(idAuthor);
    }

    @Transactional
    public boolean deleteBookFromAuthor(Long author_id, Long book_id) {
        Author author = findAuthorById(author_id);
        Book bookDelete = bookRepository.findById(book_id).orElseThrow(() ->
                new ResourceNotFoundException("Book not found"));
        author.getBooks().removeIf(book -> book.equals(bookDelete));
        authorRepository.saveAndFlush(author);
        return true;
    }

    @Transactional
    public AuthorDto findAuthorDtoById(Long author_id) {
        Author author = authorRepository.findById(author_id).orElseThrow(() ->
                new ResourceNotFoundException("Author not found"));
        return AuthorMapper.instance.authorToAuthorDto(author);
    }

    @Transactional
    public AuthorDto updateAuthor(AuthorDto authorDto) {
        Author author = authorRepository.findById(authorDto.getId()).orElseThrow(() ->
                new ResourceNotFoundException("Author not found"));
        authorRepository.saveAndFlush(AuthorMapper.instance.authorDtoToAuthor(authorDto));
        return findAuthorDtoById(author.getId());
    }

    @Transactional(readOnly = true)
    public Set<AuthorDto> getAllAuthors(){
        return AuthorMapper.instance.listAuthorToListAuthorDto(new HashSet<>(authorRepository.findAll()));
    }
    @Transactional
    public boolean addBookToAuthor(Long author_id, Long book_id) {
        Author author = findAuthorById(author_id);
        Book book = bookRepository.findById(book_id).orElseThrow(() ->
                new ResourceNotFoundException("Book not found"));
        author.getBooks().add(book);
        authorRepository.saveAndFlush(author);
        return true;
    }

    @Transactional
    public Author findAuthorById(Long author_id) {
        return authorRepository.findById(author_id).orElseThrow(() ->
                new ResourceNotFoundException("Author not found"));
    }

    @Transactional
    public Set<AuthorDto> getAuthorsOlderThan(Integer age) {
        Date date = Date.valueOf(LocalDate.now().minusYears(age));
        return AuthorMapper.instance.listAuthorToListAuthorDto(authorRepository.findAllByBornLessThanOrderByBornDesc(date));
    }

    @Transactional
    public Set<AuthorDto> getAuthorsByMostNumberOfBooks() {
        long max = 0;
        List<Author> all = authorRepository.findAll();
        for (Author a : all) { if (a.getBooks().size() > max) { max = a.getBooks().size(); } }
        Set<Author> authorSet = new HashSet<>();
        long finalMax = max;
        all.forEach(author -> { if (author.getBooks().size() == finalMax) { authorSet.add(author); } });
        return AuthorMapper.instance.listAuthorToListAuthorDto(authorSet);
    }

}
