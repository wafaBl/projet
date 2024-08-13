package com.example.plateforme.services.Implementation;


import com.example.plateforme.Models.Category;
import com.example.plateforme.Repo.CategoryRepo;
import com.example.plateforme.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImplementation implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepository;

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findCategoryByName(String name) {
        return categoryRepository.findByName(name).orElse(null);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
