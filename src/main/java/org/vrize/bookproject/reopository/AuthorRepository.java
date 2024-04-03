package org.vrize.bookproject.reopository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vrize.bookproject.model.Author;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
