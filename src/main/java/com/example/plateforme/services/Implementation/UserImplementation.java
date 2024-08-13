package com.example.plateforme.services.Implementation;




import com.example.plateforme.Models.User;
import com.example.plateforme.Repo.UserRepo;
import com.example.plateforme.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImplementation implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public User updateUserStatus(Long userId, String status) {
        Optional<User> optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            // Assuming status is a boolean field, change as necessary
            user.setStatus(status.equalsIgnoreCase("admin")); // Example logic
            return userRepo.save(user);
        }
        return null;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return userRepo.findById(id);
    }
}
