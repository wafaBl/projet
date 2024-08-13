package com.example.plateforme.services;



import com.example.plateforme.Models.Salle;

import java.util.List;
import java.util.Optional;

public interface SalleService {
    Salle saveSalle(Salle salle);
    Optional<Salle> findSalleByName(String name);
    List<Salle> getAllSalles();
    void deleteSalle(Long id);
    List<Salle> findSallesByCapacite(int capacite);
    List<Salle> findAvailableSalles(String date);
}

