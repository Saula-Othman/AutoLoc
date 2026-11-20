package tn.esprit.autoloc.service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.EquipementRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.time.LocalDateTime;
import java.util.List;
@Service
@AllArgsConstructor
public class IVehiculeServiceImp implements IVehiculeService {

    private final VehiculeRepository vehiculeRepository;
    private final EquipementRepository equipementRepository;

    @Override
    public Vehicule ajouterVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule modifierVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public List<Vehicule> afficherToutesVehicules() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule afficherVehiculeById(long id) {
        return vehiculeRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerVehicule(long id) {
        vehiculeRepository.deleteById(id);

    }

    @Override
    @Transactional
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).orElseThrow();
        Equipement equipement = equipementRepository.findById(idEquipement).orElseThrow();
        vehicule.getEquipement().add(equipement);
        return vehiculeRepository.save(vehicule);
    }

    @Override
    @Transactional
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).orElseThrow();
        vehicule.getEquipement().removeIf(e -> e.getIdEquipement().equals(idEquipement));
        return vehiculeRepository.save(vehicule);
    }

    @Scheduled(initialDelay = 5000, fixedRate = 60000)
    public void actualiserEtatVehicules() {
        List<Vehicule> vehicules = vehiculeRepository.findAll();

        System.out.println("\n======== ACTUALISATION DES VEHICULES =========");
        System.out.println("Nombre total de vehicules : " + vehicules.size());
        System.out.println("Date d'actualisation : " + LocalDateTime.now());
    }

    @Scheduled(cron = "0 0 9 * * MON")
    public void genererRapportVehicules() {
        List<Vehicule> vehicules = vehiculeRepository.findAll();
        int total = vehicules.size();

        System.out.println("\n======== RAPPORT VEHICULES =========");
        System.out.println("Nombre total de vehicules : " + total);
        System.out.println("Date de generation : " + LocalDateTime.now());
    }
}
