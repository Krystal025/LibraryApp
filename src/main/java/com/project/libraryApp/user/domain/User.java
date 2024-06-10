package com.project.libraryApp.user.domain;

public class User {

    private String name;
    private Integer age;

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
}
