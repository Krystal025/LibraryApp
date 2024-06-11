package com.project.libraryApp.user.controller;

import com.project.libraryApp.user.domain.User;
import com.project.libraryApp.user.dto.request.UserCreateRequest;
import com.project.libraryApp.user.dto.request.UserUpdateRequest;
import com.project.libraryApp.user.dto.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private final JdbcTemplate jdbcTemplate;

    // 생성자를 만들어주면 JdbcTemplate이 자동으로 파라미터로 들어와 설정됨
    public UserController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    // 사용자 등록
    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request){ // @RequestBody : body로 들어온 데이터를 클래스로 변환
        String sql = "INSERT INTO user (name, age) VALUES (?, ?)";
        jdbcTemplate.update(sql, request.getName(), request.getAge()); // update : 변경을 의미하며, INSERT, UPDATE, DELETE에 모두 사용
    }

    // 사용자 목록 조회
    @GetMapping("/user")
    public List<UserResponse> getUsers(){
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, new RowMapper<UserResponse>() {
            @Override
            public UserResponse mapRow(ResultSet rs, int rownum) throws SQLException{
                long id = rs.getLong("id");
                String name = rs. getString("name");
                int age = rs.getInt("age");
                return new UserResponse(id, name, age);
            }
        });
    }

    // 사용자 이름 변경
    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request){
        String sql = "UPDATE user SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, request.getName(), request.getId());
    }

    // 사용자 삭제
    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name){ // query가 한개이기 때문에 객체가 아닌 @RequestParam 사용
        String sql = "DELETE FROM user WHERE name = ?";
        jdbcTemplate.update(sql, name);
    }

}
