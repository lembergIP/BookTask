package ua.lviv.sombra.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import ua.lviv.sombra.entiry.Author;
import ua.lviv.sombra.entiry.Book;
import ua.lviv.sombra.service.dto.AuthorDto;
import ua.lviv.sombra.service.dto.BookDto;

import java.util.Set;

@Mapper
public interface BookMapper {

    BookMapper instance = Mappers.getMapper(BookMapper.class);

    @Mappings({@Mapping(target = "authors",ignore = true)})
    BookDto bookToBookDto(Book book);

    Book bookDtoToBook(BookDto bookDto);

    Set<AuthorDto> map(Set<Author> authors);
}
