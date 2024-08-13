package com.example.plateforme.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "formations")
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Le titre de la formation ne peut pas être vide")
    private String title;

    @Column(length = 500)
    @Size(max = 500, message = "La description ne peut pas dépasser 500 caractères")
    private String description;

    @Column(nullable = false)
    @NotNull(message = "La date de la formation ne peut pas être vide")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "formateur_id")
    private User formateur;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "formation_modules",
            joinColumns = @JoinColumn(name = "formation_id"),
            inverseJoinColumns = @JoinColumn(name = "module_id")
    )
    private Set<Module> modules = new HashSet<>();

    // Constructeurs
    public Formation() {
    }

    public Formation(String title, String description, LocalDate date, User formateur, Category category) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.formateur = formateur;
        this.category = category;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getFormateur() {
        return formateur;
    }

    public void setFormateur(User formateur) {
        this.formateur = formateur;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Module> getModules() {
        return modules;
    }

    public void setModules(Set<Module> modules) {
        this.modules = modules;
    }

    @Override
    public String toString() {
        return "Formation{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", formateur=" + (formateur != null ? formateur.getUsername() : "N/A") +
                ", category=" + (category != null ? category.getName() : "N/A") +
                '}';
    }
}
