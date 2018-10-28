package ua.lviv.sombra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.sombra.entiry.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
