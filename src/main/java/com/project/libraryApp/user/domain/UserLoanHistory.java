package com.project.libraryApp.user.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false)
    private long userId;

    @Column(nullable = false)
    private long bookId;

    private boolean isReturn;  // "0:false, 1:true" 로 매핑됨

    public UserLoanHistory(long userId, long bookId, boolean isReturn){
        this.userId = userId;
        this.bookId = bookId;
        this.isReturn = isReturn;
    }

}
