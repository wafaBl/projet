package com.example.plateforme.services;



import com.example.plateforme.Models.Module;

import java.util.List;
import java.util.Optional;

public interface ModuleService {
    /**
     * Enregistre un module dans la base de données.
     * @param module le module à enregistrer
     * @return le module enregistré
     */
    Module saveModule(Module module);

    /**
     * Trouve un module par son titre.
     * @param titre le titre du module
     * @return un Optional contenant le module s'il est trouvé, sinon un Optional vide
     */
    Optional<Module> findByTitre(String titre);

    /**
     * Récupère tous les modules.
     * @return une liste de tous les modules
     */
    List<Module> getAllModules();

    /**
     * Supprime un module par son identifiant.
     * @param id l'identifiant du module à supprimer
     */
    void deleteModule(Long id);
}

