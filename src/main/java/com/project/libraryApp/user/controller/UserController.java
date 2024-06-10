package com.project.libraryApp.user.controller;

import com.project.libraryApp.user.domain.User;
import com.project.libraryApp.user.dto.request.UserCreateRequest;
import com.project.libraryApp.user.dto.response.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
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

    // 사용자 목록 조회
    @GetMapping("/user")
    public List<UserResponse> getUsers(){
        // 등록된 users의 정보를 UserResponse 타입으로 변경해서 반환
        List<UserResponse> responses = new ArrayList<>();
        for (int i=0; i<users.size(); i++){
            responses.add(new UserResponse(i+1, users.get(i)));
        }
        return responses;
    }

}
