package ua.lviv.sombra.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = "authors")
public class BookDto {

    private Long id;
    private String name;
    private Date published;
    private String genre;
    private Float rating;
    private Set<AuthorDto> authors = new HashSet<>();

}
