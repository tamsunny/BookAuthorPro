package org.vrize.bookproject.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.vrize.bookproject.model.Book;

@RestController
public class BookController {

    @PostMapping("/books")
    public void createBooks(@RequestBody Book book){



    }
}
