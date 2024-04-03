package org.vrize.bookproject.reopository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vrize.bookproject.model.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
