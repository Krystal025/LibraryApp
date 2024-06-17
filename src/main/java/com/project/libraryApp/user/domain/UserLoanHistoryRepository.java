package com.project.libraryApp.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long> {

    boolean existsByBookIdAndIsReturn(long bookId, boolean isReturn);
}
