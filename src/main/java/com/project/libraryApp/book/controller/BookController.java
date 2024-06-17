package com.project.libraryApp.book.controller;

import com.project.libraryApp.book.domain.Book;
import com.project.libraryApp.book.dto.request.BookCreateRequest;
import com.project.libraryApp.book.dto.request.BookLoanRequest;
import com.project.libraryApp.book.dto.request.BookReturnRequest;
import com.project.libraryApp.book.service.BookService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    // 책 등록 API
    @PostMapping("/book")
    public void saveBook(@RequestBody BookCreateRequest request){
        bookService.saveBook(request);}

    // 책 대출 API
    @PostMapping("/book/loan")
    public void loanBook(@RequestBody BookLoanRequest request){
        bookService.loanBook(request);
    }

    // 책 반납 API
    @PutMapping("/book/return")
    public void returnBook(@RequestBody BookReturnRequest request){
        bookService.returnBook(request);
    }

}
