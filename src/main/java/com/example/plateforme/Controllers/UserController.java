package com.example.plateforme.Controllers;
import com.example.plateforme.Models.User;
import com.example.plateforme.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Endpoint to create or update a user.
     * @param user the user entity to save or update.
     * @return ResponseEntity with the saved user and HTTP status.
     */
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    /**
     * Endpoint to get a user by their ID.
     * @param id the ID of the user.
     * @return ResponseEntity with the user and HTTP status.
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userService.findUserById(id);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /**
     * Endpoint to get a user by their username.
     * @param username the username of the user.
     * @return ResponseEntity with the user and HTTP status.
     */
    @GetMapping("/username/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        Optional<User> user = userService.findByUsername(username);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /**
     * Endpoint to get a user by their email.
     * @param email the email of the user.
     * @return ResponseEntity with the user and HTTP status.
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        Optional<User> user = userService.findByEmail(email);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /**
     * Endpoint to get all users.
     * @return ResponseEntity with the list of all users and HTTP status.
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    /**
     * Endpoint to delete a user by their ID.
     * @param id the ID of the user.
     * @return ResponseEntity with HTTP status.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * Endpoint to update the status of a user.
     * @param id the ID of the user.
     * @param status the new status.
     * @return ResponseEntity with the updated user and HTTP status.
     */
    @PutMapping("/{id}/status")
    public ResponseEntity<User> updateUserStatus(@PathVariable Long id, @RequestParam String status) {
        User updatedUser = userService.updateUserStatus(id, status);
        return updatedUser != null ? ResponseEntity.ok(updatedUser)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
