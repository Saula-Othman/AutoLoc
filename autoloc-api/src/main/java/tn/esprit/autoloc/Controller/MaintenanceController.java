package tn.esprit.autoloc.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;

@RestController
@Tag(name = "Maintenances", description = "Gestion des maintenances")
@AllArgsConstructor
@RequestMapping("/maintenances")
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;

    @Operation(summary = "Ajouter une maintenance", description = "Crée une maintenance")
    @PostMapping("/ajouterMaintenance")
    public Maintenance ajouterMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.ajouterMaintenance(maintenance);
    }

    @Operation(summary = "Modifier une maintenance", description = "Modifier une maintenance")
    @PutMapping("/modifierMaintenance")
    public Maintenance modifierMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.modifierMaintenance(maintenance);
    }

    @Operation(summary = "Lister les maintenances", description = "Afficher la liste de toutes les maintenances")
    @GetMapping("/afficherToutesMaintenances")
    public List<Maintenance> afficherToutesMaintenances() {
        return maintenanceService.afficherToutesMaintenance();
    }

    @Operation(summary = "Afficher une maintenance", description = "Afficher une maintenance selon son id")
    @GetMapping("/afficherMaintenance/{idMaintenance}")
    public Maintenance afficherMaintenanceById(@PathVariable Long idMaintenance) {
        return maintenanceService.afficherMaintenanceById(idMaintenance);
    }





    @Operation(summary = "Supprimer une maintenance", description = "Supprime une maintenance selon son id")
    @DeleteMapping("/supprimerMaintenance/{idMaintenance}")
    public void supprimerMaintenance(@PathVariable Long idMaintenance) {
        maintenanceService.supprimerMaintenance(idMaintenance);
    }
}
