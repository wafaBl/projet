package com.example.plateforme.Repo;


import com.example.plateforme.Models.Role;
import com.example.plateforme.Models.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for managing Role entities.
 */
@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

    /**
     * Finds a role by its name.
     *
     * @param name the name of the role
     * @return an Optional containing the found role or empty if not found
     */
    Optional<Role> findByName(ERole name);
}

