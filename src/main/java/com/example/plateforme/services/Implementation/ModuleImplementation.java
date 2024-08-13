package com.example.plateforme.services.Implementation;



import com.example.plateforme.Models.Module;
import com.example.plateforme.Repo.ModuleRepo;
import com.example.plateforme.services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleImplementation implements ModuleService {

    @Autowired
    private ModuleRepo moduleRepository;

    @Override
    public Module saveModule(Module module) {
        return moduleRepository.save(module);
    }

    @Override
    public Optional<Module> findByTitre(String titre) {
        return moduleRepository.findByTitre(titre);
    }

    @Override
    public List<Module> getAllModules() {
        return moduleRepository.findAll(); // Returns List<Module>
    }

    @Override
    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }
}
