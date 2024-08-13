package com.example.plateforme.services;



import com.example.plateforme.Models.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
    // Enregistrer une nouvelle réservation
    Reservation saveReservation(Reservation reservation);

    // Trouver une réservation par son ID
    Reservation findReservationById(Long id);

    // Obtenir toutes les réservations
    List<Reservation> getAllReservations();

    // Supprimer une réservation par son ID
    void deleteReservation(Long id);

    // Trouver toutes les réservations pour une salle spécifique
    List<Reservation> findReservationsBySalleId(Long salleId);

    // Trouver toutes les réservations pour une formation spécifique
    List<Reservation> findReservationsByFormationId(Long formationId);

    // Trouver toutes les réservations à une certaine date
    List<Reservation> findReservationsByDate(LocalDate date);

    // Trouver toutes les réservations pour une salle spécifique à une certaine date
    List<Reservation> findReservationsBySalleIdAndDate(Long salleId, LocalDate date);

    // Trouver toutes les réservations pour une formation spécifique à une certaine date
    List<Reservation> findReservationsByFormationIdAndDate(Long formationId, LocalDate date);
}

