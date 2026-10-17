package tn.esprit.autoloc.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vehicules")
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @PostMapping("/ajouterVehicule")
    public Vehicule ajouterVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.ajouterVehicule(vehicule);
    }

    @PutMapping("/modifierVehicule")
    public Vehicule modifierVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.modifierVehicule(vehicule);
    }

    @GetMapping("/afficherToutesVehicules")
    public List<Vehicule> afficherToutesVehicules() {
        return vehiculeService.afficherToutesVehicules();
    }

    @GetMapping("/afficherVehicule/{idVehicule}")
    public Vehicule afficherVehiculeById(@PathVariable Long idVehicule) {
        return vehiculeService.afficherVehiculeById(idVehicule);
    }

    @DeleteMapping("/supprimerVehicule/{idVehicule}")
    public void supprimerVehicule(@PathVariable Long idVehicule) {
        vehiculeService.supprimerVehicule(idVehicule);
    }
}
