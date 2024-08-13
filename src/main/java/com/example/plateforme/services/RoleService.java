package com.example.plateforme.services;


import com.example.plateforme.Models.Role;
import com.example.plateforme.Models.ERole;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing roles in the system.
 */
public interface RoleService {

    /**
     * Saves a role in the repository.
     *
     * @param role the role to save
     * @return the saved role
     */
    Role saveRole(Role role);

    /**
     * Finds a role by its name.
     *
     * @param name the name of the role
     * @return an Optional containing the found role or empty if not found
     */
    Optional<Role> findRoleByName(ERole name);

    /**
     * Finds a role by its ID.
     *
     * @param id the ID of the role
     * @return an Optional containing the found role or empty if not found
     */
    Optional<Role> findRoleById(Long id);

    /**
     * Retrieves all roles in the repository.
     *
     * @return a list of all roles
     */
    List<Role> getAllRoles();

    /**
     * Deletes a role by its ID.
     *
     * @param id the ID of the role to delete
     */
    void deleteRole(Long id);
}
