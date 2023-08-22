package com.guthza.library.repository;

import com.guthza.library.entities.Author;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends MongoRepository<Author, ObjectId> {

    Optional<Author> getAuthorByOlIdIs(String olId);
    Author getAuthorBy_id(ObjectId _id);
    Author getAuthorByName(String name);
}
