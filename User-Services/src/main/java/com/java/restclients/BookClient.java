package com.java.restclients;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="books", url = "http://localhost:8000")
public interface BookClient {
    @GetMapping("/booksapp/v1/books")
    public List<User> getBooks();
}