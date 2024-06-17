package com.project.libraryApp.book.controller;

import com.project.libraryApp.book.domain.Book;
import com.project.libraryApp.book.dto.request.BookCreateRequest;
import com.project.libraryApp.book.dto.request.BookLoanRequest;
import com.project.libraryApp.book.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping("/book")
    public void saveBook(@RequestBody BookCreateRequest request){
        bookService.saveBook(request);}


    @PostMapping("/book/loan")
    public void loanBook(@RequestBody BookLoanRequest request){
        bookService.loanBook(request);
    }
}
