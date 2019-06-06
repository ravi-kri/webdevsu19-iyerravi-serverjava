package com.example.wbdvsu119serverjava.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbdvsu119serverjava.models.User;

@RestController
public class UserController {
    private User[] users = {
            new User(1, "alice", "alice", "Alice", "Wonderland"),
            new User(2, "bob", "bob", "Bob", "The builder"),
            new User(3, "charlier", "charlier", "Charlier", "Brown")
    };
    List<User> userArrayList = new ArrayList<User>(Arrays.asList(users));
    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userArrayList;
    }
    @DeleteMapping("/users/{userId}")
    public User[] deleteUser(@PathVariable("userId") int userId) {
        User u = null;
        for(User user:userArrayList) {
            if(user.getId() == userId) {
                u = user;
            }
        }
        userArrayList.remove(u);
        return users;
    }
    
    @PostMapping("/users")
    public List<User> createUser(@RequestBody User user) {
        userArrayList.add(user);
        return userArrayList;
    }
    
}
