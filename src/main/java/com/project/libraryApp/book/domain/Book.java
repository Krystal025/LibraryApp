package com.project.libraryApp.book.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false)
    private String name;

    protected Book(){};

    public Book(String name){
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.", name));
        }
        this.name = name;
    };
}
