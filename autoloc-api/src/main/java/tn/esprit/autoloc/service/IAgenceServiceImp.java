package tn.esprit.autoloc.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.AgenceRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class        IAgenceServiceImp implements IAgenceService{

    private final AgenceRepository agenceRepository;
    private final VehiculeRepository vehiculeRepository;

    @Override
    public Agence ajouterAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence modifierAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public List<Agence> afficherToutesAgences() {
        return agenceRepository.findAll();
    }

    @Override
    public Agence afficherAgenceById(Long id) {
        return agenceRepository.findById(id).orElse(null) ;
    }

    @Override
    public void supprimerAgence(Long id) {
        agenceRepository.deleteById(id);

    }

    @Override
    @Transactional
    public Agence ajouterAgenceEtAffecterVehicules(Agence agence) {
        List<Vehicule> vehicules = new ArrayList<>();
        if (agence.getVehicules() != null) {
            vehicules.addAll(agence.getVehicules());
        }
        agence.setVehicules(new ArrayList<>());
        Agence agenceSauvee = agenceRepository.save(agence);
        for (Vehicule v : vehicules) {
            v.setAgence(agenceSauvee);
            vehiculeRepository.save(v);
        }
        return agenceSauvee;
    }
}
