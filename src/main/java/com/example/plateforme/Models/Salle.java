package com.example.plateforme.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "salles")
public class Salle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "Le nom de la salle ne peut pas être vide")
    @Size(min = 3, max = 100, message = "Le nom de la salle doit contenir entre 3 et 100 caractères")
    private String nom;

    @Column(nullable = false)
    private boolean disponible;

    @Column(nullable = false)
    @Positive(message = "La capacité doit être un nombre positif")
    private int capacite;

    @OneToMany(mappedBy = "salle", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Reservation> reservations = new HashSet<>();

    // Constructeurs
    public Salle() {
    }

    public Salle(String nom, boolean disponible, int capacite) {
        this.nom = nom;
        this.disponible = disponible;
        this.capacite = capacite;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public String toString() {
        return String.format("Salle{id=%d, nom='%s', disponible=%b, capacite=%d}", id, nom, disponible, capacite);
    }
}
