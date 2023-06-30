package com.example.basicSpring;

import com.example.basicSpring.model.Author;
import com.example.basicSpring.repository.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthorList implements CommandLineRunner {
    private final AuthorRepository authorRepository;

    public AuthorList(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author("Dr. Seuss");
        Author author2 = new Author("R.L Stine");
        authorRepository.save(author1);
        authorRepository.save(author2);

    }
}
