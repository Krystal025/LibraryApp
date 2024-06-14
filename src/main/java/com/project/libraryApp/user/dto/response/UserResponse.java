package com.project.libraryApp.user.dto.response;

import com.project.libraryApp.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private long id;
    private String name;
    private Integer age;

    public UserResponse(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.age = user.getAge();
    }

    public UserResponse(long id, User user){
        this.id = id;
        this.name = user.getName();
        this.age = user.getAge();
    }

}
