package com.camomila.bookstoremanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundexception extends Exception {

    public BookNotFoundexception(Long id) {
        super(String.format("Book with ID not found.", id));
    }
}
