package com.project.libraryApp.user.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class UserLoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @JoinColumn
    @ManyToOne
    private User user;

    @Column(nullable = false)
    private String bookName;

    private boolean isReturn;  // "0:false, 1:true" 로 매핑됨

    public UserLoanHistory(User user, String bookName){
        this.user = user;
        this.bookName = bookName;
        this.isReturn = false;
    }

    public void doReturn(){
       this.isReturn = true;
    }
}
