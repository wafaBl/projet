package com.example.plateforme.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "modules")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Le titre du module ne peut pas être vide")
    @Size(min = 3, max = 100, message = "Le titre du module doit contenir entre 3 et 100 caractères")
    private String titre;

    @Column(length = 500)
    @Size(max = 500, message = "La description ne peut pas dépasser 500 caractères")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "modules")
    private Set<Formation> formations = new HashSet<>();

    // Constructeurs
    public Module() {
    }

    public Module(String titre, String description) {
        this.titre = titre;
        this.description = description;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Formation> getFormations() {
        return formations;
    }

    public void setFormations(Set<Formation> formations) {
        this.formations = formations;
    }

    @PreRemove
    private void preRemove() {
        for (Formation formation : formations) {
            formation.getModules().remove(this);
        }
    }

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
