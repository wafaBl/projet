package com.example.plateforme.Repo;

import com.example.plateforme.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for {@link User} entity.
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    static Optional<User> findUserById(Long id) {
        return null;
    }

    /**
     * Finds a user by their email.
     * @param email the email of the user.
     * @return an Optional containing the found user or empty if not found.
     */
    Optional<User> findByEmail(String email);

    /**
     * Checks if a user with the given email exists.
     * @param email the email to check.
     * @return true if a user with the given email exists, false otherwise.
     */
    Boolean existsByEmail(String email);

    /**
     * Finds a user by their username.
     * @param username the username of the user.
     * @return an Optional containing the found user or empty if not found.
     */
    Optional<User> findByUsername(String username);
}

