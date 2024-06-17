package com.project.libraryApp.book.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    // SERLECT * FROM user_loan_history WHERE book_name = ? AND is_return = ?;
    Optional<Book> findByName(String bookName);
}
