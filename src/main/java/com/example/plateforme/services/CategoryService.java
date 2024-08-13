package com.example.plateforme.services;



import com.example.plateforme.Models.Category;

import java.util.List;

public interface CategoryService {
    // Enregistrer une nouvelle catégorie
    Category saveCategory(Category category);

    // Trouver une catégorie par son nom
    Category findCategoryByName(String name);

    // Obtenir toutes les catégories
    List<Category> getAllCategories();

    // Supprimer une catégorie par son ID
    void deleteCategory(Long id);
}

