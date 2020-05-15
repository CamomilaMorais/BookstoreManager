package com.camomila.bookstoremanager.service;

import com.camomila.bookstoremanager.dto.MessageResponseDTO;
import com.camomila.bookstoremanager.entity.Book;
import com.camomila.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public MessageResponseDTO create(Book book){
        Book savedBook = bookRepository.save(book);
        return MessageResponseDTO.builder()
                .message("Book created with ID " + savedBook.getId()).build();
    }
}
