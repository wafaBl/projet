package com.example.plateforme.services.Implementation;

import com.example.plateforme.Models.Course;
import com.example.plateforme.Repo.CourseRepo;
import com.example.plateforme.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


import com.example.plateforme.Models.Course;
import com.example.plateforme.Repo.CourseRepo;
import com.example.plateforme.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseImplementation implements CourseService {

    @Autowired
    private CourseRepo courseRepository;

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Optional<Course> findByTitle(String title) {
        return courseRepository.findByTitle(title);
    }

    @Override
    public Optional<Course> findByName(String name) {
        // Assurez-vous que le repository a une méthode appropriée pour cela
        // return courseRepository.findByName(name);
        return Optional.empty(); // Placeholder - changez ceci selon la logique réelle
    }

    @Override
    public List<Course> getAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
