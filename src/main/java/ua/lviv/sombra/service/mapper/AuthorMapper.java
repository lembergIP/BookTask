package ua.lviv.sombra.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import ua.lviv.sombra.entiry.Author;
import ua.lviv.sombra.entiry.Book;
import ua.lviv.sombra.service.dto.AuthorDto;
import ua.lviv.sombra.service.dto.BookDto;

import java.util.List;
import java.util.Set;

@Mapper
public interface AuthorMapper {

    AuthorMapper instance = Mappers.getMapper(AuthorMapper.class);

    @Mappings({@Mapping(target = "books", ignore = true)})
    AuthorDto authorToAuthorDto(Author author);

    Author authorDtoToAuthor(AuthorDto authorDto);

    Set<AuthorDto> listAuthorToListAuthorDto(Set<Author> authors);

    default Set<BookDto> map(Set<Book> books) {
        return BookMapper.instance.listBookToListBookDto(books);
    }

    ;
}
