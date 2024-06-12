package com.project.libraryApp.user.service;

import com.project.libraryApp.user.dto.request.UserCreateRequest;
import com.project.libraryApp.user.dto.request.UserUpdateRequest;
import com.project.libraryApp.user.dto.response.UserResponse;
import com.project.libraryApp.user.repository.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;

    public UserService(JdbcTemplate jdbcTemplate) {
        userRepository = new UserRepository(jdbcTemplate);
    }

    // 사용자 등록 메소드
    public void saveUser(UserCreateRequest request){
        userRepository.saveUser(request.getName(), request.getAge());
    }

    // 사용자 목록 조회 메소드
    public List<UserResponse> getUsers(){
        return userRepository.getUsers();
    }

    // 사용자 이름 변경 메소드
    public void updateUser(UserUpdateRequest request) {
        if (userRepository.isUserNotExist(request.getId())) {
            throw new IllegalArgumentException();
        }
        userRepository.updateUserName(request.getName(), request.getId());
    }

    // 사용자 사제 메소드
    public void deleteUser(String name){
        if (userRepository.isUserNotExist(name)) {
            throw new IllegalArgumentException();
        }
        userRepository.deleteUser(name);
    }

}
