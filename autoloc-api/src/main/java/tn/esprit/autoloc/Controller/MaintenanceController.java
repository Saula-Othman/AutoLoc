package tn.esprit.autoloc.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/maintenances")
public class MaintenanceController {

    private final IMaintenanceService maintenanceService;

    @PostMapping("/ajouterMaintenance")
    public Maintenance ajouterMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.ajouterMaintenance(maintenance);
    }

    @PutMapping("/modifierMaintenance")
    public Maintenance modifierMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.modifierMaintenance(maintenance);
    }

    @GetMapping("/afficherToutesMaintenances")
    public List<Maintenance> afficherToutesMaintenances() {
        return maintenanceService.afficherToutesMaintenance();
    }

    @GetMapping("/afficherMaintenance/{idMaintenance}")
    public Maintenance afficherMaintenanceById(@PathVariable Long idMaintenance) {
        return maintenanceService.afficherMaintenanceById(idMaintenance);
    }





    @DeleteMapping("/supprimerMaintenance/{idMaintenance}")
    public void supprimerMaintenance(@PathVariable Long idMaintenance) {
        maintenanceService.supprimerMaintenance(idMaintenance);
    }
}
