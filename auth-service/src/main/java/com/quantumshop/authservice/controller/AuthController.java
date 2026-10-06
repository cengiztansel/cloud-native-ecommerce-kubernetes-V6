package com.quantumshop.authservice.controller;
import com.quantumshop.authservice.dto.LoginRequest;
import com.quantumshop.authservice.dto.RegisterRequest;
import com.quantumshop.authservice.model.UserAccount;
import com.quantumshop.authservice.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService service;
    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public UserAccount register(@RequestBody RegisterRequest request) {
        return service.register(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        return service.login(
                request.getUsername(),
                request.getPassword());
    }

}
