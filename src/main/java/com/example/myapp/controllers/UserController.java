package com.example.myapp.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.myapp.models.User;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private User[] users = {
            new User(123, "alice", "alice", "Alice", "Wonderland","Faculty"),
            new User(234, "bob", "bob", "Bob", "The builder","Student"),
            new User(345, "charlie", "charlie", "Charlie", "Brown","Admin")
    };
    // previous version
    // private ArrayList<User> userArrayList = new ArrayList<User>(Arrays.asList(users));
    
    List<User> userArrayList = new ArrayList<User>(Arrays.asList(users));
    
    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userArrayList;
    }
    @DeleteMapping("/users/{userId}")
    public List<User> deleteUser(@PathVariable("userId") long userId) {
        User u = null;
        for(User user:userArrayList) {
            if(user.getId() == userId) {
                u = user;
            }
        }
        userArrayList.remove(u);
        return userArrayList;
    }
    
    @GetMapping("/users/{userId}")
    public User findUserById(@PathVariable("userId") long userId) {
        User u = null;
        for(User user:userArrayList) {
            if(user.getId() == userId) {
                u = user;
            }
        }
        return u;
    }
    
    @PostMapping("/users/{userId}")
    public void updateUser(@PathVariable("userId") long userId,@PathVariable("user") User inc_user) {
        for(User user:userArrayList) {
            if(user.getId() == userId) {
                user = inc_user;
            }
        }
    }
    
    @PostMapping("/users")
    public List<User> createUser(@RequestBody User user) {
        userArrayList.add(user);
        return userArrayList;
    }
    // previous version
    // @GetMapping("/users")
    // public User[] findAllUsers() {
    //     return users;
    // }
    // @DeleteMapping("/users/{userId}")
    // public ArrayList<User> deleteUser(@PathVariable("userId") int userId){
    // // public User[] deleteUser(@PathVariable("userId") int userId) {
        
    //     User u = null;
    //     for(User user:userArrayList) {
    //         if(user.getId() == userId) {
    //             u = user;
    //         }
    //     }
    //     userArrayList.remove(u);
    //     return userArrayList;
    // }

    // @PostMapping("/users")
    // public List<User> createUser(@RequestBody User user){
    //     userArrayList.add(user);
    //     return userArrayList;
    // }
}
