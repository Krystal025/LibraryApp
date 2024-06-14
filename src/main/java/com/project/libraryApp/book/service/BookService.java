package com.project.libraryApp.book.service;

import com.project.libraryApp.book.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void saveBook(){
        bookRepository.saveBook();
    }
}
