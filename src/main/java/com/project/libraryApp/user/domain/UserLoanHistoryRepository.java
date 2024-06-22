package com.project.libraryApp.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {

    // 도서 대출여부
    boolean existsByBookNameAndIsReturn(String bookName, boolean isReturn);

    // 사용자의 도서 대출 기록
    Optional<UserLoanHistory> findByUserIdAndBookName(long userId, String bookName);

}
