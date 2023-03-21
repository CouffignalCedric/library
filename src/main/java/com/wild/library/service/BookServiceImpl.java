package com.wild.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wild.library.models.Book;
import com.wild.library.repository.BookRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> read() {
        return bookRepository.findAll();
    }

    @Override
    public Book readById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public Book update(Long id, Book book) {
        return bookRepository.findById(id)
                .map(bk -> {
                    bk.setTitle(book.getTitle());
                    bk.setAuthor(book.getAuthor());
                    bk.setDescription(book.getDescription());
                    return bookRepository.save(bk);

                }).orElseThrow(() -> new RuntimeException("book non trouvé!"));

    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> findByTitleOrAuthor(String searchTerm, String searchTerm2) {
        return bookRepository.findByTitleContainingOrAuthorContaining(searchTerm, searchTerm2);
    }

}
