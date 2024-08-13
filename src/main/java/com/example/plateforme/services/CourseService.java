package com.example.plateforme.services;


import com.example.plateforme.Models.Course;
import java.util.List;
import java.util.Optional;

public interface CourseService {

    // Sauvegarder un cours
    Course saveCourse(Course course);

    // Trouver un cours par titre
    Optional<Course> findByTitle(String title);

    // Trouver un cours par nom (si vous avez un attribut spécifique pour le nom)
    Optional<Course> findByName(String name);

    // Obtenir tous les cours
    List<Course> getAllCourses();

    // Supprimer un cours par ID
    void deleteCourse(Long id);
}

