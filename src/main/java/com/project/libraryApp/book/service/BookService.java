package com.project.libraryApp.book.service;

import com.project.libraryApp.book.domain.Book;
import com.project.libraryApp.book.domain.BookRepository;
import com.project.libraryApp.book.dto.request.BookCreateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void saveBook(BookCreateRequest request){
        bookRepository.save(new Book(request.getName()));
    };
}
