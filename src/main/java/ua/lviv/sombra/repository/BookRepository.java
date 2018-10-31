package ua.lviv.sombra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.sombra.entiry.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

int countBooksByGenre(String genre);
}
