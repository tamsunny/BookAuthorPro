package org.vrize.bookproject.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.vrize.bookproject.model.Book;
import org.vrize.bookproject.reopository.BookRepository;
import org.vrize.bookproject.service.BookService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;


    @GetMapping("/allBooks")
    public List<Book> allBook() {
        List<Book> booksList = bookService.findAllBooks();
        return booksList;
    }

    @GetMapping("/getBookByName/{name}")
    public Book getBookByName(@PathVariable String name) {
        Book book = bookService.findBookByName(name);
        return book;

    }

    @GetMapping("/getBookByAuthorName/{name}")
    public List<Book> getBookByAuthorName(@PathVariable String name) {
        List<Book> book = bookService.findBookByAuthorName(name);
        return book;

    }

    @PostMapping("/saveBooks")
    public ResponseEntity<List<Book>> addBook(@RequestBody List<Book> booksList) {
        List<Book> newbooksList = new ArrayList<>();
        for (Book book : booksList) {
            newbooksList.add(bookService.addBook(book));
        }

        return new ResponseEntity<>(newbooksList, HttpStatus.CREATED);

    }

    @PutMapping("/updateBook/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book updatedbook) {
        return bookService.updateBook(id, updatedbook);
    }
}
