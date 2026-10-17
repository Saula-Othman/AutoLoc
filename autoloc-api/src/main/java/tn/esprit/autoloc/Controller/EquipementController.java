package tn.esprit.autoloc.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/equipements")
public class EquipementController {

    private final IEquipementService equipementService;

    @PostMapping("/ajouterEquipement")
    public Equipement ajouterEquipement(@RequestBody Equipement equipement) {
        return equipementService.ajouterEquipement(equipement);
    }

    @PutMapping("/modifierEquipement")
    public Equipement modifierEquipement(@RequestBody Equipement equipement) {
        return equipementService.modifierEquipement(equipement);
    }

    @GetMapping("/afficherToutesEquipements")
    public List<Equipement> afficherToutesEquipements() {
        return equipementService.afficherToutesEquipement();
    }

    @GetMapping("/afficherEquipement/{idEquipement}")
    public Equipement afficherEquipementById(@PathVariable Long idEquipement) {
        return equipementService.afficherEquipementById(idEquipement);
    }



    @DeleteMapping("/supprimerEquipement/{idEquipement}")
    public void supprimerEquipement(@PathVariable Long idEquipement) {
        equipementService.supprimerEquipement(idEquipement);
    }
}
