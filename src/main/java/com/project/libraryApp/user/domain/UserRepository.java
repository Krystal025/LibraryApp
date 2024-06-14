package com.project.libraryApp.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;

// @JpaRepository를 상속받으므로써 Spring Bean 등록이 되기 때문에 @Repository가 따로 필요없음
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

}
