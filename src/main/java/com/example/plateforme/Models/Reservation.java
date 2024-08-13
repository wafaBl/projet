package com.example.plateforme.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "La date de la réservation ne peut pas être nulle")
    private LocalDate date;

    @Column(nullable = false)
    @NotNull(message = "L'heure de la réservation ne peut pas être nulle")
    private LocalTime heure;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "salle_id", nullable = false)
    @NotNull(message = "La salle ne peut pas être nulle")
    private Salle salle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formation_id", nullable = false)
    @NotNull(message = "La formation ne peut pas être nulle")
    private Formation formation;

    // Constructeurs
    public Reservation() {
    }

    public Reservation(LocalDate date, LocalTime heure, Salle salle, Formation formation) {
        this.date = date;
        this.heure = heure;
        this.salle = salle;
        this.formation = formation;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", date=" + date +
                ", heure=" + heure +
                ", salle=" + (salle != null ? salle.getNom() : "Non spécifiée") +
                ", formation=" + (formation != null ? formation.getTitle() : "Non spécifiée") +
                '}';
    }
}
