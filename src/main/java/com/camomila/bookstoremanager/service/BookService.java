package com.camomila.bookstoremanager.service;

import com.camomila.bookstoremanager.dto.BookDTO;
import com.camomila.bookstoremanager.dto.MessageResponseDTO;
import com.camomila.bookstoremanager.entity.Book;
import com.camomila.bookstoremanager.mapper.BookMapper;
import com.camomila.bookstoremanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @PostMapping
    public MessageResponseDTO create(BookDTO bookDTO){
        //  Book bookToSave = Book.builder()
        //  .name(bookDTO.getName())
        //  .chapters(bookDTO.getChapters())
        //  .isbn(bookDTO.getIsbn())
        //  .author(bookDTO.getAuthor())
        //  (...)
        //  .build();
        Book bookToSave = bookMapper.toModel(bookDTO);

        Book savedBook = bookRepository.save(bookToSave);
        return MessageResponseDTO.builder()
                .message("Book created with ID " + savedBook.getId()).build();
    }

    public BookDTO findById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return bookMapper.toDTO(optionalBook.get());
    }
}
