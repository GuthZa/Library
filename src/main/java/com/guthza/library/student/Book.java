package com.guthza.library.student;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "librarycollection")
public class Book {
    @Id
    private ObjectId _id;
    private String olId;
    private String title;
    private String description;
    private Integer releaseDate;
    private String author;
    private String cover;
    private List<String> genre;
    private Integer pages;

    public Book(String title, String description, Integer releaseDate, String author) {
        this.title = title;
        this.description = description;
        this.releaseDate = releaseDate;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                ", olId='" + olId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", releaseDate=" + releaseDate +
                ", author='" + author + '\'' +
                ", cover='" + cover + '\'' +
                ", genre=" + genre +
                ", pages=" + pages +
                '}';
    }
}
