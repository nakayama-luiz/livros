package com.example.orliv.controller;


import com.example.orliv.model.user;
import com.example.orliv.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<user> create(@RequestBody user user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    @GetMapping("/userByname")
    public ResponseEntity<List<user>> getUserByName(@RequestParam String name){
            return ResponseEntity.status(HttpStatus.FOUND).body(userService.findByName(name));
    }
}
