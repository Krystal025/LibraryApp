package com.project.libraryApp.user.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    // 도서 반납 상태값 변경 메소드
    public void doReturn(){
       this.isReturn = true;
    }

}
