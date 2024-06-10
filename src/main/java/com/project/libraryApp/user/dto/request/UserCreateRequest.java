package com.project.libraryApp.user.dto.request;

import lombok.Getter;

@Getter
public class UserCreateRequest {

    private String name;
    private Integer age;  // age는 선택이기 때문에 null값을 허용할 수 있는 Integer 사용

}
