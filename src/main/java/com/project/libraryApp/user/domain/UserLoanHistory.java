package com.project.libraryApp.user.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @JoinColumn(nullable = false)
    @ManyToOne
    private User user;

    private long bookId;

    private boolean isReturn;  // "0:false, 1:true" 로 매핑됨

    public UserLoanHistory(User user, long bookId){
        this.user = user;
        this.bookId = bookId;
        this.isReturn = false;
    }

    public void doReturn(){
       this.isReturn = true;
    }
}
