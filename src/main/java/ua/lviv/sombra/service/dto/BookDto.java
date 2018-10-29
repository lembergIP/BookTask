package ua.lviv.sombra.service.dto;

import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class BookDto {

    private Long id;
    private String name;
    private Date published;
    private String genre;
    private Float rating;
    private Set<AuthorDto> authors=new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublished() {
        return published;
    }

    public void setPublished(Date published) {
        this.published = published;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Set<AuthorDto> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorDto> authors) {
        this.authors = authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookDto)) return false;
        BookDto bookDto = (BookDto) o;
        return Objects.equals(getId(), bookDto.getId()) &&
                Objects.equals(getName(), bookDto.getName()) &&
                Objects.equals(getPublished(), bookDto.getPublished()) &&
                Objects.equals(getGenre(), bookDto.getGenre()) &&
                Objects.equals(getRating(), bookDto.getRating()) &&
                Objects.equals(getAuthors(), bookDto.getAuthors());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPublished(), getGenre(), getRating(), getAuthors());
    }
}
