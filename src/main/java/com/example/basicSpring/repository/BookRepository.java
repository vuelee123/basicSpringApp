package com.example.basicSpring.repository;


import com.example.basicSpring.model.Book;
import com.example.basicSpring.repository.BookRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
