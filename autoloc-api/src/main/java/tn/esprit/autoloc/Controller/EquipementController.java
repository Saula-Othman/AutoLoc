package tn.esprit.autoloc.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@Tag(name = "Équipements", description = "Gestion des équipements")
@AllArgsConstructor
@RequestMapping("/equipements")
public class EquipementController {

    private final IEquipementService equipementService;

    @Operation(summary = "Ajouter un équipement", description = "Crée un équipement")
    @PostMapping("/ajouterEquipement")
    public Equipement ajouterEquipement(@RequestBody Equipement equipement) {
        return equipementService.ajouterEquipement(equipement);
    }

    @Operation(summary = "Modifier un équipement", description = "Modifier un équipement")
    @PutMapping("/modifierEquipement")
    public Equipement modifierEquipement(@RequestBody Equipement equipement) {
        return equipementService.modifierEquipement(equipement);
    }

    @Operation(summary = "Lister les équipements", description = "Afficher la liste de tous les équipements")
    @GetMapping("/afficherToutesEquipements")
    public List<Equipement> afficherToutesEquipements() {
        return equipementService.afficherToutesEquipement();
    }

    @Operation(summary = "Afficher un équipement", description = "Afficher un équipement selon son id")
    @GetMapping("/afficherEquipement/{idEquipement}")
    public Equipement afficherEquipementById(@PathVariable Long idEquipement) {
        return equipementService.afficherEquipementById(idEquipement);
    }



    @Operation(summary = "Supprimer un équipement", description = "Supprime un équipement selon son id")
    @DeleteMapping("/supprimerEquipement/{idEquipement}")
    public void supprimerEquipement(@PathVariable Long idEquipement) {
        equipementService.supprimerEquipement(idEquipement);
    }
}
