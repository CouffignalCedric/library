package com.wild.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wild.library.models.Book;
import com.wild.library.service.BookService;

import java.util.*;
import lombok.AllArgsConstructor;

@RestController
// @RequestMapping("/books")
@AllArgsConstructor
public class BookRestcontroller {

    @Autowired
     BookService bookService;

    @PostMapping("/book")
    public Book create(@RequestBody Book book){
    return bookService.create(book);
}
@PostMapping("/book/search")
public List<Book> search(@RequestBody Map<String, String> body){
    String searchTerm = body.get("title");
   return bookService.findByTitleOrAuthor(searchTerm, searchTerm);
}   

    @GetMapping("/book")
    public List<Book> read(){
        return bookService.read();
    }
    @GetMapping("/book/{id}")
    public Book readById(@PathVariable Long id, @RequestBody Book book){
        return bookService.readById(id);
    }
    @PutMapping("/book/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book book){
        return bookService.update(id, book);

    }
    @DeleteMapping("/book/{id}")
    public void delete(@PathVariable Long id){
       
    }
}
