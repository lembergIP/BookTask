package ua.lviv.sombra.service;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.sombra.entiry.Author;
import ua.lviv.sombra.repository.AuthorRepository;
import ua.lviv.sombra.repository.BookRepository;
import ua.lviv.sombra.service.dto.AuthorDto;
import ua.lviv.sombra.service.mapper.AuthorMapper;

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
    public AuthorDto findAuthorDtoById(Long idAuthor) {
        Author author = authorRepository.findById(idAuthor).orElseThrow(() ->
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
}
