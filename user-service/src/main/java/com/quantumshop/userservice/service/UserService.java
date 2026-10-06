package com.quantumshop.userservice.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.quantumshop.userservice.model.UserEntity;
import com.quantumshop.userservice.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserEntity save(UserEntity user) {
        return repository.save(user);
    }

    public List<UserEntity> findAll() {
        return repository.findAll();
    }
}
