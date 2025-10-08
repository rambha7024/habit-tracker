package com.example.habit_tracker.controller;

import com.example.habit_tracker.model.User;
import com.example.habit_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Register a new user
    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return "Username already exists!";
        }
        userRepository.save(user);
        return "User registered successfully!";
    }

    // List all users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
