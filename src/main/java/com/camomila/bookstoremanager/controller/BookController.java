package com.camomila.bookstoremanager.controller;

import com.camomila.bookstoremanager.dto.BookDTO;
import com.camomila.bookstoremanager.dto.MessageResponseDTO;
import com.camomila.bookstoremanager.entity.Book;
import com.camomila.bookstoremanager.exception.BookNotFoundexception;
import com.camomila.bookstoremanager.repository.BookRepository;
import com.camomila.bookstoremanager.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO){
        return bookService.create(bookDTO);
    }

    @GetMapping("/{id}")
    public BookDTO findById(@PathVariable Long id) throws BookNotFoundexception {
        return bookService.findById(id);
    }
}
