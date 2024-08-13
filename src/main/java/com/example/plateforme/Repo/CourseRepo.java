package com.example.plateforme.Repo;



import com.example.plateforme.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long> {



    // Trouver des cours associés à un module
    List<Course> findByModuleId(Long moduleId);

    Optional<Course> findByTitle(String title);
}

