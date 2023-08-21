package com.guthza.library.entities;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;


@Document(collection = "authors")
public class Author {

    @Id
    private ObjectId _id;
    private String olId;
    private String name;
    private String description;
    @DocumentReference
    private List<Book> bookIds;
}
