package com.project.libraryApp.user.controller;

import com.project.libraryApp.user.dto.request.UserCreateRequest;
import com.project.libraryApp.user.dto.request.UserUpdateRequest;
import com.project.libraryApp.user.dto.response.UserResponse;
import com.project.libraryApp.user.service.UserServiceV1;
import com.project.libraryApp.user.service.UserServiceV2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    // @Autowired를 사용해도되지만 직접 생성자를 정의하는 것이 오류방지에 더 효과적임
    private final UserServiceV2 userService;

    // 생성자를 만들어주면 JdbcTemplate이 자동으로 파라미터로 들어와 설정됨
    public UserController(UserServiceV2 userService){
        this.userService = userService;
    }

    // 사용자 등록 API
    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request){ // @RequestBody : body로 들어온 데이터를 클래스로 변환
        userService.saveUser(request);
    }

    // 사용자 목록 조회 API
    @GetMapping("/user")
    public List<UserResponse> getUsers(){
        return userService.getUsers();
    }

    // 사용자 이름 변경 API
    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request){
        userService.updateUser(request);
    }

    // 사용자 삭제 API
    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name){ // query가 한개이기 때문에 객체가 아닌 @RequestParam 사용
        userService.deleteUser(name);
    }

}
