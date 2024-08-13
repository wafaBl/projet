package com.example.plateforme.Repo;



import com.example.plateforme.Models.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SalleRepo extends JpaRepository<Salle, Long> {
    // Trouver une salle par son nom
    Optional<Salle> findByNom(String nom);

    // Trouver toutes les salles ayant une capacité supérieure ou égale à une certaine valeur
    List<Salle> findByCapaciteGreaterThanEqual(int capacite);

    // Trouver toutes les salles disponibles à une certaine date
    @Query("SELECT s FROM Salle s WHERE s.id NOT IN (SELECT r.salle.id FROM Reservation r WHERE r.date = :date)")
    List<Salle> findAvailableSallesByDate(@Param("date") String date);

    List<Salle> findByReservations_DateNotContaining(String date);
}
