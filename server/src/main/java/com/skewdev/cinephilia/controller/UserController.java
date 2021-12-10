package com.skewdev.cinephilia.controller;

import com.skewdev.cinephilia.entity.User;
import com.skewdev.cinephilia.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/register")
    private ResponseEntity<String> registerUser(@Valid @RequestBody User newUser){
        usersService.saveUser(newUser);
        return ResponseEntity.ok().body("User created");
    }

    @GetMapping
    private ResponseEntity<List<User>> getAll(){
        List<User> users = usersService.getUsers();
        return ResponseEntity.ok().body(users);
    }
}
