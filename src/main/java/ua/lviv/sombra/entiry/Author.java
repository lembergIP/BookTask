package ua.lviv.sombra.entiry;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ua.lviv.sombra.enums.Gender;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
@Data
@EqualsAndHashCode(exclude = "books")
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "born")
    private Date born;

    @ManyToMany(cascade =
            {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            })
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "author_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<Book> books = new HashSet<>();

}
