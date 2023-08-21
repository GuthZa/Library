package com.guthza.library.controller;


import com.guthza.library.service.BookService;
import com.guthza.library.student.Book;
import org.bson.types.ObjectId;
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
@RequestMapping("api/v1/library")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<>(bookService.getAllMovies(), HttpStatus.OK);
    }
    @GetMapping("/{olId}")
    public ResponseEntity<Optional<Book>> getBookByOlId(@PathVariable String olId) {
        return new ResponseEntity<>(bookService.getSingleBook(olId), HttpStatus.OK);
    }
}
