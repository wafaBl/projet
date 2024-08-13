package com.example.plateforme.services.Implementation;


import com.example.plateforme.Models.Formation;
import com.example.plateforme.Repo.FormationRepo;
import com.example.plateforme.services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FormationImplementation implements FormationService {

    @Autowired
    private FormationRepo formationRepository;

    @Override
    public Formation saveFormation(Formation formation) {
        return formationRepository.save(formation);
    }

    @Override
    public Optional<Formation> findFormationById(Long id) {
        return formationRepository.findById(id);
    }

    @Override
    public List<Formation> getAllFormations() {
        return formationRepository.findAll();
    }

    @Override
    public void deleteFormation(Long id) {
        formationRepository.deleteById(id);
    }

    @Override
    public List<Formation> findFormationsByTitle(String title) {
        return formationRepository.findByTitle(title);
    }

    @Override
    public List<Formation> findFormationsByCategoryId(Long categoryId) {
        return formationRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<Formation> findFormationsByFormateurId(Long formateurId) {
        return formationRepository.findByFormateurId(formateurId);
    }

    @Override
    public List<Formation> findFormationsByDate(LocalDate date) {
        return formationRepository.findByDate(LocalDate.parse(date.toString()));
    }

    @Override
    public Formation updateFormation(Formation formation) {
        if (formationRepository.existsById(formation.getId())) {
            return formationRepository.save(formation);
        } else {
            throw new IllegalArgumentException("Formation not found with id: " + formation.getId());
        }
    }
}
