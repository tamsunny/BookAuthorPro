package org.vrize.bookproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
public class Author {

    @Id
    private int id;
    private String auhtor_name;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Book> books;

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", auhtor_name='" + auhtor_name + '\'' +
                '}';
    }








}
