package com.example.plateforme.services.Implementation;


import com.example.plateforme.Models.Reservation;
import com.example.plateforme.Repo.ReservationRepo;
import com.example.plateforme.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationImplementation implements ReservationService {

    @Autowired
    private ReservationRepo reservationRepository;

    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation findReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> findReservationsBySalleId(Long salleId) {
        return reservationRepository.findBySalleId(salleId);
    }

    @Override
    public List<Reservation> findReservationsByFormationId(Long formationId) {
        return reservationRepository.findByFormationId(formationId);
    }

    @Override
    public List<Reservation> findReservationsByDate(LocalDate date) {
        return reservationRepository.findByDate(date);
    }

    @Override
    public List<Reservation> findReservationsBySalleIdAndDate(Long salleId, LocalDate date) {
        return reservationRepository.findBySalleIdAndDate(salleId, date);
    }

    @Override
    public List<Reservation> findReservationsByFormationIdAndDate(Long formationId, LocalDate date) {
        return reservationRepository.findByFormationIdAndDate(formationId, date);
    }
}
