package com.dio.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class PersonNotFoundException extends ResponseStatusException {

    public PersonNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, String.format("Person with ID %s not found!", id));
    }
}
