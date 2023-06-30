package com.example.basicSpring.model;

import com.example.basicSpring.model.Book;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.data.annotation.Id;

import java.util.List;


@Entity
public class Author {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Name is required")
    @Size(min = 2, message = "Name should have at least 3 characters")
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<com.example.basicSpring.model.Book> books;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}