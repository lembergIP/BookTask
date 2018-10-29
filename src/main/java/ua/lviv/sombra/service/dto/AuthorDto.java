package ua.lviv.sombra.service.dto;

import java.sql.Date;
import java.util.Objects;
import java.util.Set;

public class AuthorDto {

    private Long id;
    private String name;
    private String gender;
    private Date born;
    private Set<BookDto> books;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    public Set<BookDto> getBooks() {
        return books;
    }

    public void setBooks(Set<BookDto> books) {
        this.books = books;
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
        if (!(o instanceof AuthorDto)) return false;
        AuthorDto authorDto = (AuthorDto) o;
        return Objects.equals(getId(), authorDto.getId()) &&
                Objects.equals(getName(), authorDto.getName()) &&
                Objects.equals(getGender(), authorDto.getGender()) &&
                Objects.equals(getBorn(), authorDto.getBorn()) &&
                Objects.equals(getBooks(), authorDto.getBooks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getGender(), getBorn(), getBooks());
    }
}
