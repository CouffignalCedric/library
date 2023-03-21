package com.wild.library.service;

import com.wild.library.models.Book;

import java.util.*;

public interface BookService {
    Book create(Book book);
    List<Book> read();
    Book update(Long id, Book book);
    void delete(Long id);
    List<Book> findByTitleOrAuthor(String searchTerm, String searchTerm2);
    Book readById(Long id);


}
