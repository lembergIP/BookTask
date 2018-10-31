package ua.lviv.sombra.service.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Data @EqualsAndHashCode(exclude = "books")
public class AuthorDto {

    private Long id;
    private String name;
    private String gender;
    private Date born;
    private Set<BookDto> books=new HashSet<>();

}
