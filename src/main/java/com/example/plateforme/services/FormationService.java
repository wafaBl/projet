package com.example.plateforme.services;



import com.example.plateforme.Models.Formation;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FormationService {
    // Sauvegarde d'une formation
    Formation saveFormation(Formation formation);

    // Recherche d'une formation par ID
    Optional<Formation> findFormationById(Long id);

    // Récupération de toutes les formations
    List<Formation> getAllFormations();

    // Suppression d'une formation par ID
    void deleteFormation(Long id);

    // Recherche de formations par titre
    List<Formation> findFormationsByTitle(String title);

    // Recherche de formations par catégorie
    List<Formation> findFormationsByCategoryId(Long categoryId);

    // Recherche de formations par formateur
    List<Formation> findFormationsByFormateurId(Long formateurId);

    // Recherche de formations par date
    List<Formation> findFormationsByDate(LocalDate date);

    // Mise à jour d'une formation
    Formation updateFormation(Formation formation);
}

