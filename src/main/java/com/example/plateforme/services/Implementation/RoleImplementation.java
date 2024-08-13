package com.example.plateforme.services.Implementation;



import com.example.plateforme.Models.Role;
import com.example.plateforme.Models.ERole;
import com.example.plateforme.Repo.RoleRepo;
import com.example.plateforme.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of RoleService interface for managing roles.
 */
@Service
public class RoleImplementation implements RoleService {

    private final RoleRepo roleRepository;

    @Autowired
    public RoleImplementation(RoleRepo roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Optional<Role> findRoleById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Optional<Role> findRoleByName(ERole name) {
        return roleRepository.findByName(name);
    }
}
