package com.project.libraryApp.user.service;

import com.project.libraryApp.user.dto.request.UserCreateRequest;
import com.project.libraryApp.user.dto.request.UserUpdateRequest;
import com.project.libraryApp.user.dto.response.UserResponse;
import com.project.libraryApp.user.repository.UserJdbcRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceV1 {

    private final UserJdbcRepository userJdbcRepository;

    public UserServiceV1(UserJdbcRepository userJdbcRepository) {
        this.userJdbcRepository = userJdbcRepository;
    }

    // 사용자 등록 메소드
    public void saveUser(UserCreateRequest request){
        userJdbcRepository.saveUser(request.getName(), request.getAge());
    }

    // 사용자 목록 조회 메소드
    public List<UserResponse> getUsers(){
        return userJdbcRepository.getUsers();
    }

    // 사용자 이름 변경 메소드
    public void updateUser(UserUpdateRequest request) {
        if (userJdbcRepository.isUserNotExist(request.getId())) {
            throw new IllegalArgumentException();
        }
        userJdbcRepository.updateUserName(request.getName(), request.getId());
    }

    // 사용자 사제 메소드
    public void deleteUser(String name){
        if (userJdbcRepository.isUserNotExist(name)) {
            throw new IllegalArgumentException();
        }
        userJdbcRepository.deleteUser(name);
    }

}
