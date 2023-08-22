package com.guthza.library.entities;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
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
    private String authorId;
    private String cover;
    private List<String> genre;
    private Integer pages;
    @Transient
    private String authorName;
}
