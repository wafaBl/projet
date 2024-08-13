package com.example.plateforme.Models;


import jakarta.persistence.*;

/**
 * Represents a role entity for different user roles in the application.
 */
@Entity
@Table(name="roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, unique = true, nullable = false)
    private ERole name;

    /**
     * Default constructor required by JPA.
     */
    public Role() {
    }

    /**
     * Constructor to create a Role with a specified name.
     *
     * @param name the role name
     */
    public Role(ERole name) {
        this.name = name;
    }

    /**
     * Gets the id of the role.
     *
     * @return the id of the role
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id of the role.
     *
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the role.
     *
     * @return the name of the role
     */
    public ERole getName() {
        return name;
    }

    /**
     * Sets the name of the role.
     *
     * @param name the name to set
     */
    public void setName(ERole name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
