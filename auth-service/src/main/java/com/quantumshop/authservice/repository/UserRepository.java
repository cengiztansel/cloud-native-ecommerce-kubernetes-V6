package com.quantumshop.authservice.repository;
import com.quantumshop.authservice.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository
        extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> findByUsername(String username);
}
