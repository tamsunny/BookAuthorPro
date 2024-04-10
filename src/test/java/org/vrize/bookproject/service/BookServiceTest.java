package org.vrize.bookproject.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.vrize.bookproject.model.Book;
import org.vrize.bookproject.reopository.AuthorRepository;
import org.vrize.bookproject.reopository.BookRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    public void testFindAllBooks(){
        List<Book> dummyBookList = new ArrayList<>();
        dummyBookList.add(new Book());
        dummyBookList.add(new Book());
        dummyBookList.add(new Book());
        when(bookRepository.findAll()).thenReturn(dummyBookList);
        List<Book> result = bookService.findAllBooks();
        assertEquals(3,result.size());
    }







}
