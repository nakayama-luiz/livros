package com.example.orliv.controller;


import com.example.orliv.domain.User;
import com.example.orliv.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController extends GenericCrudController<User, Long> {
    private final UserService userService;

    protected UserController(UserService service, UserService userService) {
        super(service);
        this.userService = userService;
    }


    @GetMapping("/name")
    public ResponseEntity<List<User>> getUserByName(@RequestParam String name) {
            return ResponseEntity.status(HttpStatus.FOUND).body(userService.findByName(name));
    }
}
