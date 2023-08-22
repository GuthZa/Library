package com.guthza.library.service;

import com.guthza.library.entities.Author;
import com.guthza.library.entities.Book;
import com.guthza.library.repository.AuthorRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(String olId) {
        return authorRepository.getAuthorByOlIdIs(olId);
    }

    public Author getAuthorByName(String name) {
        return authorRepository.getAuthorByName(name);
    }
}
