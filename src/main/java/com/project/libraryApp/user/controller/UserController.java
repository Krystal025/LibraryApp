package com.project.libraryApp.user.controller;

import com.project.libraryApp.user.domain.User;
import com.project.libraryApp.user.dto.request.UserCreateRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final List<User> users = new ArrayList<>();

    // 사용자 등록 요청
    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request){ // @RequestBody : body로 들어온 데이터를 클래스로 변환
        users.add(new User(request.getName(), request.getAge()));
    }

}
