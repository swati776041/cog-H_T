package com.java.controller;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.java.model.Users;
import com.java.restclients.BookClient;


@RestController
@RequestMapping("/books/users")
public class UsersController {

    @Autowired
    private BookClient bookClient;
    
    @GetMapping()
    public List<Users> getUsers(){
        return List.of(
            new Users(1, "sam", "Guest", "sam@gmail.com"),
            new Users(2, "satvik", "reader", "sathiv@gmail.com"),
            new Users(3, "somu", "author", "somu@gmail.com"),
            new Users(4, "shiva", "Guest", "shiva@gmail.com")
        );
    } 

    @GetMapping("/books")
   
    public List<User> getBooks(){
        System.out.println("Finding books from bookservice");
       

        return bookClient.getBooks();
    } 

}