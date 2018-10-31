package ua.lviv.sombra.entiry;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;


@Entity
@Data @EqualsAndHashCode(exclude = "authors")
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,name = "name")
    private String name;

    @Column(name = "published")
    private Date published;

    @Column(name = "genre")
    private String genre;

    @Column(name = "rating")
    private Float rating;

    @ManyToMany(cascade =
            {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.PERSIST
            } )
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"),inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors=new HashSet<>();

}
