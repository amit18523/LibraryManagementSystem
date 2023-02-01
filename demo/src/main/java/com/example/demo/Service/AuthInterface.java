package com.example.demo.Service;

import com.example.demo.Model.Author;

import java.util.List;

public interface AuthInterface {
    Author createAuthor(Author author);
    Author updateAuthor(Author author);
    List<Author> getAllAuthor();
    Author getAuthorById(long id);

    void deleteAuthor(long id);
}
