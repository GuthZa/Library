package com.guthza.library.controller;

import com.guthza.library.entities.Author;
import com.guthza.library.exceptions.AuthorNotFoundException;
import com.guthza.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.OK);
    }

    @GetMapping("/{olId}")
    public ResponseEntity<Optional<Author>> getAuthor(@PathVariable String olId) {
        return new ResponseEntity<>(authorService.getAuthorById(olId), HttpStatus.OK);
    }

    @GetMapping("/name={name}")
    public ResponseEntity<Author> getAuthorByName(@PathVariable String name) {
        Author author = authorService.getAuthorByName(name);
        if(author==null) throw new AuthorNotFoundException("Author by the name " + name + " not found!");
        return new ResponseEntity<>(authorService.getAuthorByName(name), HttpStatus.OK);
    }
}