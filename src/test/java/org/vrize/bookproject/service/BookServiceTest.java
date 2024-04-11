package org.vrize.bookproject.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.vrize.bookproject.model.Author;
import org.vrize.bookproject.model.Book;
import org.vrize.bookproject.reopository.AuthorRepository;
import org.vrize.bookproject.reopository.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@SpringBootTest
@PrepareForTest(BookService.class)
public class BookServiceTest {

    @Mock
    BookRepository bookRepository;

    @Mock
    AuthorRepository authorRepository;

    @InjectMocks
    BookService bookService;


    @Test
    public void testFindAllBooks() {
        List<Book> dummyBookList = new ArrayList<>();
        dummyBookList.add(new Book());
        dummyBookList.add(new Book());
        dummyBookList.add(new Book());
        when(bookRepository.findAll()).thenReturn(dummyBookList);
        List<Book> result = bookService.findAllBooks();
        assertEquals(3, result.size());
    }


    @Test
    public void testaddBook() {
        Author author = new Author();
        Book book = new Book();
        when(authorRepository.findById(any(Integer.class))).thenReturn(Optional.of(author));
        when(authorRepository.save(any(Author.class))).thenReturn(author);
        book.setAuthor(author);
        when(bookRepository.save(book)).thenReturn(book);
        Book result = bookService.addBook(book);
        assertEquals(book, result);

    }

    @Test
    public void testUpdateBook() {
        Book book = new Book();
        Author author = new Author();
        when(bookRepository.findById(any(Integer.class))).thenReturn(Optional.of(book));
        book.setBookname("dummyname");
        book.setAuthor(author);
        when(bookRepository.save(any(Book.class))).thenReturn(book);
        Book result = bookService.updateBook(any(Integer.class), book);
        assertEquals(book, result);

    }

    @Test
    public void testfindBookByName(){
        Book book = new Book();
        when(bookRepository.findBookByBookname("dummyName")).thenReturn(book);
        Book result = bookService.findBookByName("dummyName");
        assertEquals(book,result);
    }

    @Test
    public void testFindBookByAuthorName(){
        List<Book> dummyBookList = new ArrayList<>();
        dummyBookList.add(new Book());
        dummyBookList.add(new Book());
        dummyBookList.add(new Book());
        when(bookRepository.findByAuthor_Name("dummyAuthorName")).thenReturn(dummyBookList);
        List<Book> result = bookService.findBookByAuthorName("dummyAuthorName");
        assertEquals(dummyBookList.size(),result.size());
    }

}
