package org.vrize.bookproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vrize.bookproject.model.Author;
import org.vrize.bookproject.model.Book;
import org.vrize.bookproject.reopository.AuthorRepository;
import org.vrize.bookproject.reopository.BookRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> findAllBooks(){

        return  bookRepository.findAll();
    }

    public Book addBook(Book book){
        Author author = authorRepository.findById(book.getAuthor().getId()).orElse(null);
        if(author == null){
            author = authorRepository.save(book.getAuthor());
        }
        book.setAuthor(author);
       Book newBook = bookRepository.save(book);
       return newBook;
    }

    public Book updateBook(int id,Book updatedBook){

        Book existingBook = bookRepository.findById(id).orElse(null);

        if(existingBook != null){
            existingBook.setBookname(updatedBook.getBookname());
            existingBook.setAuthor(updatedBook.getAuthor());
            return  bookRepository.save(existingBook);
        }else{
            return null;
        }

    }

    public Book findBookByName(String bookname){
        System.out.println(bookname);
        System.out.println(bookRepository.findBookByBookname(bookname));
       return bookRepository.findBookByBookname(bookname);
    }

    public List<Book> findBookByAuthorName(String author_name){
        return bookRepository.findByAuthor_Name(author_name);
    }


}
