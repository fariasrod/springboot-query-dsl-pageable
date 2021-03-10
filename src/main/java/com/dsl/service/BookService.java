package com.dsl.service;

import com.dsl.filter.BookFilter;
import com.dsl.model.Book;
import com.dsl.repository.BookRepository;
import com.dsl.repository.dsl.BookFilterDsl;
import com.dsl.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> find(final BookFilter filter, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> books = repository.findAll(BookFilterDsl.filter(filter), pageable);
        System.out.println("TotalElements : " + books.getTotalElements());
        System.out.println("TotalPages : " + books.getTotalPages());
        System.out.println("Number : " + books.getNumber());
        System.out.println("NumberOfElements : " + books.getNumberOfElements());
        System.out.println("Size : " + books.getSize());
        return Convert.toList(books);
    }
}
