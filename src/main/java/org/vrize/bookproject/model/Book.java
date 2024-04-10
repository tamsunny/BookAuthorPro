package org.vrize.bookproject.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    private int id;
    private String bookname;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;




    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", author=" + author +
                '}';
    }



}
