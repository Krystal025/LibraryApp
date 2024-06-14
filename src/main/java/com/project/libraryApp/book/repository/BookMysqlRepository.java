package com.project.libraryApp.book.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class BookMysqlRepository implements BookRepository {

    @Override
    public void saveBook() {

    }
}
