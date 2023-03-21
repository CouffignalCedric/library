package com.wild.library.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wild.library.models.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
    List<Book> findByTitleContainingOrAuthorContaining(String text, String textAgain);
}
