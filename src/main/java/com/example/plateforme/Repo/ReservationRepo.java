package com.example.plateforme.Repo;


import com.example.plateforme.Models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface ReservationRepo extends JpaRepository<Reservation, Long> {

    // Trouver toutes les réservations pour une salle spécifique
    List<Reservation> findBySalleId(Long salleId);

    // Trouver toutes les réservations pour une formation spécifique
    List<Reservation> findByFormationId(Long formationId);

    // Trouver toutes les réservations à une certaine date
    List<Reservation> findByDate(LocalDate date);

    // Trouver toutes les réservations pour une salle spécifique à une certaine date
    List<Reservation> findBySalleIdAndDate(Long salleId, LocalDate date);

    // Trouver toutes les réservations pour une formation spécifique à une certaine date
    List<Reservation> findByFormationIdAndDate(Long formationId, LocalDate date);
}

