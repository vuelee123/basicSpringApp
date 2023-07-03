package com.example.basicSpring.controller;

import com.example.basicSpring.model.Author;
import com.example.basicSpring.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("")
    public String showAuthorList(Model model) {
        List<Author> authors = authorRepository.findAll();
        model.addAttribute("authors", authors);
        return "author-lists";
    }

    @GetMapping("/details/{id}")
    public String getAuthorById(@PathVariable("id") Long id, Model model) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid author id: " + id));
        model.addAttribute("author", author);
        return "author-details";
    }

    @GetMapping("/add")
    public String showAddAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "author-add";
    }

    @PostMapping("/add")
    public String addAuthor(@ModelAttribute("author") @Validated Author author) {
        authorRepository.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid author id: " + id));
        model.addAttribute("author", author);
        return "author-edit";
    }

    @PostMapping("/{id}/edit")
    public String editAuthor(@PathVariable("id") Long id, @ModelAttribute("author") Author updatedAuthor, BindingResult result) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid author ID: " + id));

        if (result.hasErrors()) {
            return "author-edit";
        }

        if (updatedAuthor.getName() != null && updatedAuthor.getName().length() >= 3) {
            author.setName(updatedAuthor.getName());
            authorRepository.save(author);
        } else {
            result.rejectValue("name", "author.name", "Name should have at least 3 characters");
            return "author-edit";
        }

        return "redirect:/authors";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable("id") Long id) {
        authorRepository.deleteById(id);
        return "redirect:/authors";
    }
}
