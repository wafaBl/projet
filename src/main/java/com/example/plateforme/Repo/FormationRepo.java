package com.example.plateforme.Repo;



import com.example.plateforme.Models.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FormationRepo extends JpaRepository<Formation, Long> {

    // Trouver des formations par titre
    List<Formation> findByTitle(String title);

    // Trouver des formations par catégorie
    List<Formation> findByCategoryId(Long categoryId);

    // Trouver des formations par formateur
    List<Formation> findByFormateurId(Long formateurId);

    // Trouver des formations par date
    List<Formation> findByDate(LocalDate date); // Utilisation de LocalDate pour la date

}

