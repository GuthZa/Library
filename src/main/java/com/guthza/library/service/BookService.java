package com.guthza.library.service;

import com.guthza.library.repository.BookRepository;
import com.guthza.library.student.Book;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllMovies() {
        return bookRepository.findAll();
    }

    public Optional<Book> getSingleBook(String olId) {
        return bookRepository.findMovieByOlId(olId);
    }
}
