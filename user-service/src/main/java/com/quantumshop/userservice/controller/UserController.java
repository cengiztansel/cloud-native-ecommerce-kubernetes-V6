package com.quantumshop.userservice.controller;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.quantumshop.userservice.model.UserEntity;
import com.quantumshop.userservice.service.UserService;

import java.util.stream.Collectors;
import com.quantumshop.userservice.dto.UserResponse;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserResponse> all() {
        return service.findAll().stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

    @PostMapping
    public UserResponse create(@RequestBody UserEntity user) {
        return new UserResponse(service.save(user));
    }

}
