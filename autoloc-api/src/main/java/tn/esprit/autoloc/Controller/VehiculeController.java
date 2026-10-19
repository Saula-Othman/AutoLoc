package tn.esprit.autoloc.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@Tag(name = "Véhicules", description = "Gestion des véhicules")
@AllArgsConstructor
@RequestMapping("/vehicules")
public class VehiculeController {

    private final IVehiculeService vehiculeService;

    @Operation(summary = "Ajouter un véhicule", description = "Crée un véhicule")
    @PostMapping("/ajouterVehicule")
    public Vehicule ajouterVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.ajouterVehicule(vehicule);
    }

    @Operation(summary = "Modifier un véhicule", description = "Modifier un véhicule")
    @PutMapping("/modifierVehicule")
    public Vehicule modifierVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.modifierVehicule(vehicule);
    }

    @Operation(summary = "Lister les véhicules", description = "Afficher la liste de tous les véhicules")
    @GetMapping("/afficherToutesVehicules")
    public List<Vehicule> afficherToutesVehicules() {
        return vehiculeService.afficherToutesVehicules();
    }

    @Operation(summary = "Afficher un véhicule", description = "Afficher un véhicule selon son id")
    @GetMapping("/afficherVehicule/{idVehicule}")
    public Vehicule afficherVehiculeById(@PathVariable Long idVehicule) {
        return vehiculeService.afficherVehiculeById(idVehicule);
    }

    @Operation(summary = "Supprimer un véhicule", description = "Supprime un véhicule selon son id")
    @DeleteMapping("/supprimerVehicule/{idVehicule}")
    public void supprimerVehicule(@PathVariable Long idVehicule) {
        vehiculeService.supprimerVehicule(idVehicule);
    }
}
