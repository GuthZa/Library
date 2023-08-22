package com.guthza.library.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;


@Data
@AllArgsConstructor
@Document(collection = "authors")
public class Author {

    @Id
    private ObjectId _id;
    private String olId;
    private String name;
    private String dateOfBirth;
    @DocumentReference
    private List<Book> bookIds;
}
