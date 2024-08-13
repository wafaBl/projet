package com.example.plateforme.services;



import com.example.plateforme.Models.User;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing {@link User} entities.
 */
public interface UserService {

    /**
     * Saves a user entity to the database.
     * @param user the user entity to save.
     * @return the saved user entity.
     */
    User saveUser(User user);

    /**
     * Finds a user by their username.
     * @param username the username of the user.
     * @return an Optional containing the found user or empty if not found.
     */
    Optional<User> findByUsername(String username);

    /**
     * Finds a user by their email.
     * @param email the email of the user.
     * @return an Optional containing the found user or empty if not found.
     */
    Optional<User> findByEmail(String email);

    /**
     * Retrieves all user entities from the database.
     * @return a list of all users.
     */
    List<User> getAllUsers();

    /**
     * Deletes a user entity by its ID.
     * @param userId the ID of the user to delete.
     */
    void deleteUser(Long userId);

    /**
     * Updates the status of a user.
     * @param userId the ID of the user to update.
     * @param status the new status to set.
     * @return the updated user entity or null if the user was not found.
     */
    User updateUserStatus(Long userId, String status);

    /**
     * Finds a user by their ID.
     * @param id the ID of the user.
     * @return an Optional containing the found user or empty if not found.
     */
    Optional<User> findUserById(Long id);
}
