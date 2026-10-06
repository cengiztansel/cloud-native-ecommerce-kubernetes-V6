package com.quantumshop.authservice.service;
import com.quantumshop.authservice.dto.RegisterRequest;
import com.quantumshop.authservice.model.UserAccount;
import com.quantumshop.authservice.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository repository;
    private final BCryptPasswordEncoder encoder;
    private final JwtService jwtService;

    public AuthService(UserRepository repository, BCryptPasswordEncoder encoder, JwtService jwtService) {
        this.repository = repository;
        this.encoder = encoder;
        this.jwtService = jwtService;
    }

    public UserAccount register(RegisterRequest request) {
        UserAccount user = new UserAccount();
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRole("USER");
        return repository.save(user);
    }

    public String login(String username, String password) {
        UserAccount user = repository.findByUsername(username).orElseThrow();
        if (!encoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Wrong password");
        }
      //  return jwtService.generateToken(username);
        return jwtService.generateToken(username, user.getRole());
    }
////////////////////////////////////////////////////////////////////////////////////////////

}