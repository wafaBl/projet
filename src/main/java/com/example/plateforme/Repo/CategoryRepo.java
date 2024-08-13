package com.example.plateforme.Repo;



import com.example.plateforme.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category, Long> {

    // Trouver une catégorie par nom
    Optional<Category> findByName(String name);

    // Trouver toutes les catégories dont le nom contient une certaine chaîne
    List<Category> findByNameContaining(String name);
}

