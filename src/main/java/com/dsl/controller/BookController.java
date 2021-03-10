package com.dsl.controller;

import com.dsl.filter.BookFilter;
import com.dsl.model.Book;
import com.dsl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("")
    public ResponseEntity<List<Book>> find(@Validated @RequestBody final BookFilter filter,
                                           @RequestParam(value = "page", defaultValue = "0") Integer page,
                                           @RequestParam(value = "size", defaultValue = "10") Integer size) {
        return new ResponseEntity<>(service.find(filter, page, size), HttpStatus.OK);
    }
}
