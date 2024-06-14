package com.project.libraryApp.user.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity  // @Entity : Spring이 해당 객체와 테이블을 같은 것으로 보게함 (Entity : DB에서 관리되어야할 데이티)
@Getter
public class User {

    @Id  // Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto Invrement
    private Long id = null;

    @Column(nullable = false, length = 20)
    private String name;

    // age는 따로 설정할 내용이 없으므로 @Column 생략가능
    private Integer age;

    protected User(){}

    // User 객체가 생성될 때마다 name과 age를 매개변수로 받음
    public User(String name, Integer age){
        // name이 없다면 예외를 발생시킴 (= 생성되지 않음)
        if(name == null || name.isEmpty()){
            // IllegalArgumentException : 부적절한 인수를 받았을 때 발생 (String.format : 예외 메세지)
            throw new IllegalArgumentException(String.format("잘못된 이름 'name(%s)'이 들어왔습니다.", name));
        }
        this.name = name;
        this.age = age;
    }

    public void updateName(String name){
        this.name =  name;
    }
}
