package org.vrize.bookproject.controller;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.vrize.bookproject.model.Author;
import org.vrize.bookproject.model.Book;
import org.vrize.bookproject.service.BookService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@PrepareForTest({BookController.class})
public class BookControllerTest {

    @Mock
    BookService bookService;

    @InjectMocks
    BookController bookController;

    @Test
    public void testAllBook() throws Exception {
        // Create some dummy books for testing
        List<Book> booksList = new ArrayList<>();
        booksList.add(new Book(1, "Book1", new Author()));
        booksList.add(new Book(2, "Book2", new Author()));
        booksList.add(new Book(3, "Book3", new Author()));

        // Mock the behavior of the bookService.findAllBooks() method
        when(bookService.findAllBooks()).thenReturn(booksList);

        // Call the method to be tested
        List<Book> result = bookController.allBook();

        // Verify the result
        assertEquals(3, result.size()); // Assuming 3 books were returned
    }

    @Test
    public void testGetBookByNmae() {
        Book dummybook = new Book();
        when(bookService.findBookByName("dummy book")).thenReturn(dummybook);
        Book result = bookController.getBookByName("dummy book");
        assertEquals(dummybook, result);
    }

    @Test
    public void testGetBookByAuthorName() {
        List<Book> dummyBookList = new ArrayList<>();
        dummyBookList.add(new Book());
        dummyBookList.add(new Book());
        dummyBookList.add(new Book());
        when(bookService.findBookByAuthorName("dummyAuthorName")).thenReturn(dummyBookList);
        List<Book> result = bookController.getBookByAuthorName("dummyAuthorName");
        assertEquals(3, result.size());
    }

    @Test
    public void testAddBook() {
        List<Book> dummyBookList = new ArrayList<>();
        dummyBookList.add(new Book());
        dummyBookList.add(new Book());
        dummyBookList.add(new Book());

        List<Book> mockedBookResponse = new ArrayList<>();
        mockedBookResponse.add(new Book());
        mockedBookResponse.add(new Book());
        mockedBookResponse.add(new Book());

        when(bookService.addBook(dummyBookList.get(0))).thenReturn(mockedBookResponse.get(0));
        when(bookService.addBook(dummyBookList.get(1))).thenReturn(mockedBookResponse.get(1));

        ResponseEntity<List<Book>> result = bookController.addBook(dummyBookList);
        assertEquals(HttpStatus.CREATED,result.getStatusCode());
        assertEquals(mockedBookResponse.size(),result.getBody().size());
    }

    @Test
    public void testUpdateBook(){
        Book dummyBook = new Book();
        when(bookService.updateBook(any(Integer.class),any(Book.class))).thenReturn(dummyBook);
        Book result = bookController.updateBook(1, dummyBook);
        assertEquals(dummyBook,result);
    }
}
