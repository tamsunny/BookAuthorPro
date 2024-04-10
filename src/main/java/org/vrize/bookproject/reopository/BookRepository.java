package org.vrize.bookproject.reopository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.vrize.bookproject.model.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

Book findBookByBookname(String bookname);
@Query("SELECT b FROM Book b where  b.author.auhtor_name=:author_name")
List<Book> findByAuthor_Name(@Param("author_name") String author_name);
}
