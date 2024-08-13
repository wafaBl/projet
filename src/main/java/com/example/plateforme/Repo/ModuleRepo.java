package com.example.plateforme.Repo;


import com.example.plateforme.Models.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModuleRepo extends JpaRepository<Module, Long> {

    /**
     * Trouver un module par son titre.
     * @param titre le titre du module
     * @return un Optional contenant le module s'il est trouvé, sinon un Optional vide
     */
    Optional<Module> findByTitre(String titre);

    /**
     * Trouver des modules dont la description contient une certaine chaîne de caractères.
     * @param description la chaîne de caractères à rechercher dans la description
     * @return une liste de modules correspondant à la recherche
     */
    List<Module> findByDescriptionContaining(String description);

    /**
     * Trouver des modules associés à une formation spécifique.
     * @param formationId l'identifiant de la formation
     * @return une liste de modules associés à la formation
     */
    List<Module> findByFormationsId(Long formationId);
}

