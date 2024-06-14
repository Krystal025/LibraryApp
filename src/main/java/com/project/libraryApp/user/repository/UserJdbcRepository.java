package com.project.libraryApp.user.repository;

import com.project.libraryApp.user.dto.response.UserResponse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserJdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserJdbcRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    // 사용자 등록 query
    public void saveUser(String name, Integer age) {
        String sql = "INSERT INTO user (name, age) VALUES (?, ?)";
        jdbcTemplate.update(sql, name, age); // update : 변경을 의미하며, INSERT, UPDATE, DELETE에 모두 사용
    }

    // 사용자 목록 조회 query
    public List<UserResponse> getUsers(){
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql, (rs, rownum) -> {
                    long id = rs.getLong("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    return new UserResponse(id, name, age);
                });
    }

    // 사용자 존재 조회 query (사용자 이름 변경시 사용)
    public boolean isUserNotExist(long id){
        String readSql = "SELECT * FROM user WHERE id = ?";
        return jdbcTemplate.query(readSql, (rs, rownum) -> 0, id).isEmpty();
    }

    // 사용자 이름 변경 query
    public void updateUserName(String name, long id){
        String sql = "UPDATE user SET name = ? WHERE id = ?";
        jdbcTemplate.update(sql, name, id);
    }

    // 사용자 존재 조회 query (사용자 삭제시 사용)
    public boolean isUserNotExist(String name){
        String readSql = "SELECT * FROM user WHERE name = ?";
        return jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();
    }

    // 사용자 삭제 query
    public void deleteUser(String name){
        String sql = "DELETE FROM user WHERE name = ?";
        jdbcTemplate.update(sql, name);
    }

}
