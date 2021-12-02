package com.skewdev.cinephilia.controller;

import com.skewdev.cinephilia.entity.User;
import com.skewdev.cinephilia.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    private ResponseEntity<?> registerUser(@RequestBody User newUser){
        userRepository.save(newUser);
        return ResponseEntity.ok().body("User created");
    }
}
