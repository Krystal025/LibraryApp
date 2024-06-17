package com.project.libraryApp.book.service;

import com.project.libraryApp.book.domain.Book;
import com.project.libraryApp.book.domain.BookRepository;
import com.project.libraryApp.book.dto.request.BookCreateRequest;
import com.project.libraryApp.book.dto.request.BookLoanRequest;
import com.project.libraryApp.user.domain.User;
import com.project.libraryApp.user.domain.UserLoanHistory;
import com.project.libraryApp.user.domain.UserLoanHistoryRepository;
import com.project.libraryApp.user.domain.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;
    private final UserRepository userRepository;

    public BookService(BookRepository bookRepository, UserLoanHistoryRepository userLoanHistoryRepository, UserRepository userRepository){
        this.bookRepository = bookRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveBook(BookCreateRequest request){
        bookRepository.save(new Book(request.getName()));
    };

    @Transactional
    public void loanBook(BookLoanRequest request){
        // 1. 책 정보를 가져옴
        Book book = bookRepository.findByName(request.getBookName())
                .orElseThrow(IllegalArgumentException :: new);
        // 2. 대출기록을 통해 대출여부를 확인함
        if (userLoanHistoryRepository.existsByBookIdAndIsReturn(book.getId(), false)){
            // 3. 만약 대출중이라면 예외를 발생시킴
            throw new IllegalArgumentException("대출중인 책입니다.");
        }
        // 4. 사용자 정보를 가져옴
        User user = userRepository.findByName(request.getUserName());
        if (user == null){
            throw new IllegalArgumentException();
        }
        // 5. 사용자 정보와 책정보를 기반으로 UserLoanHistory를 저장
        userLoanHistoryRepository.save(new UserLoanHistory(user.getId(), book.getId(), false));

    }
}
