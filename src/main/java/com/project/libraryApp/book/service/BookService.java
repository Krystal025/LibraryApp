package com.project.libraryApp.book.service;

import com.project.libraryApp.book.domain.Book;
import com.project.libraryApp.book.domain.BookRepository;
import com.project.libraryApp.book.dto.request.BookCreateRequest;
import com.project.libraryApp.book.dto.request.BookLoanRequest;
import com.project.libraryApp.book.dto.request.BookReturnRequest;
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

    // 도서 등록 메소드
    @Transactional
    public void saveBook(BookCreateRequest request){
        bookRepository.save(new Book(request.getName()));
    };

    // 도서 대출 메소드
    @Transactional
    public void loanBook(BookLoanRequest request){
        // 1. 사용자 정보를 가져옴
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException :: new);
        // 2. 도서 정보를 가져옴
        Book book = bookRepository.findByName(request.getBookName())
                .orElseThrow(()-> new IllegalArgumentException(String.format("등록되지 않는 책입니다.")));
        // 3. 대출기록을 통해 대출여부를 확인함
        if (userLoanHistoryRepository.existsByBookNameAndIsReturn(book.getName(), false)){
            // 4. 만약 대출중이라면 예외를 발생시킴
            throw new IllegalArgumentException("대출중인 책입니다.");
        }
        // 5. 사용자 정보와 도서 정보를 기반으로 UserLoanHistory를 저장
        user.loanBook(book.getName());
        //userLoanHistoryRepository.save(new UserLoanHistory(user, book.getId()));
    }

    // 도서 반납 메소드
    @Transactional
    public void returnBook(BookReturnRequest request){
        // 1. 사용자 정보를 가져옴
        User user = userRepository.findByName(request.getUserName())
                .orElseThrow(IllegalArgumentException :: new);
        // 2. 도서 정보를 가져옴
        Book book = bookRepository.findByName(request.getBookName())
                .orElseThrow(()-> new IllegalArgumentException(String.format("등록되지 않는 책입니다.")));
        // 3. 사용자 정보와 도서 정보를 통해 대출기록을 가져옴
        UserLoanHistory history = userLoanHistoryRepository.findByUserIdAndBookName(user.getId(), book.getName())
                .orElseThrow(IllegalArgumentException :: new);
        // 4. 반납처리
        user.returnBook(request.getBookName());
        // history.doReturn();
        // @Transactional 사용중이기 때문에 별도의 저장이 필요없음

    }
}
