package com.guthza.library.service;

import com.guthza.library.entities.Author;
import com.guthza.library.repository.AuthorRepository;
import com.guthza.library.repository.BookRepository;
import com.guthza.library.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> getAllMovies() {
        List<Book> books = bookRepository.findAll();

        for(Book book : books) {
            Author author = authorRepository.getAuthorBy_id(book.get_id());
            if(author!=null) {
                book.setAuthorName(author.getName());
            }
        }
        return books;
    }

    public Optional<Book> getBookByOlId(String olId) {
        return bookRepository.findMovieByOlId(olId);
    }

    public Optional<Book> getBookByTitle(String title) {
        return bookRepository.findMovieByTitle(title);
    }

    public List<Book> getBookByAuthorId(@PathVariable String authorId) { return bookRepository.findBookByAuthorId(authorId); }
}
