package com.example.plateforme.services.Implementation;



import com.example.plateforme.Models.Salle;
import com.example.plateforme.Repo.SalleRepo;
import com.example.plateforme.services.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalleImplementation implements SalleService {

    @Autowired
    private SalleRepo salleRepo;

    @Override
    public Salle saveSalle(Salle salle) {
        try {
            return salleRepo.save(salle);
        } catch (Exception e) {
            // Gérer les exceptions (log, rethrow, etc.)
            throw new RuntimeException("Erreur lors de l'enregistrement de la salle", e);
        }
    }

    @Override
    public Optional<Salle> findSalleByName(String name) {
        return salleRepo.findByNom(name);
    }

    @Override
    public List<Salle> getAllSalles() {
        return salleRepo.findAll();
    }

    @Override
    public void deleteSalle(Long id) {
        try {
            salleRepo.deleteById(id);
        } catch (Exception e) {
            // Gérer les exceptions (log, rethrow, etc.)
            throw new RuntimeException("Erreur lors de la suppression de la salle", e);
        }
    }

    @Override
    public List<Salle> findSallesByCapacite(int capacite) {
        return salleRepo.findByCapaciteGreaterThanEqual(capacite);
    }

    @Override
    public List<Salle> findAvailableSalles(String date) {
        // Assurez-vous que la méthode dans SalleRepo correspond à vos besoins
        return salleRepo.findByReservations_DateNotContaining(date);
    }
}
