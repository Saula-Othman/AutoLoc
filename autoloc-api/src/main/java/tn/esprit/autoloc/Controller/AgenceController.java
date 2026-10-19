package tn.esprit.autoloc.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@Tag(name = "Agences", description = "Gestion des agences")
@AllArgsConstructor
@RequestMapping("/agences")

public class AgenceController {

    private final IAgenceService agenceService;

    @Operation(summary = "Lister les agences", description = "Afficher la liste de toutes les agences")
    @GetMapping("/afficherToutesAgences")
    public List<Agence> getALLAgences() {
        return agenceService.afficherToutesAgences();
    }


    @Operation(summary = "Ajouter une agence", description = "Crée une agence ")
    @PostMapping("/ajouterAgences")
    public Agence ajouterAgence(@RequestBody Agence agence) {
        return agenceService.ajouterAgence(agence);
    }

    @Operation(summary = "Modifier une agence", description = "Modifer une agence ")
    @PutMapping("/modifierAgences")
    public Agence modifierAgence(@RequestBody Agence agence) {
        return agenceService.modifierAgence(agence);
    }

    @Operation(summary = "Supprimer une agence", description = "Supprime une agence selon son id")
    @DeleteMapping("/supprimerAgence/{idAgence}")
    public void supprimerAgence(@PathVariable Long idAgence) {
        agenceService.supprimerAgence(idAgence);
    }

    @Operation(summary = "Afficher une agence", description = "Afficher une agence selon son id")
    @GetMapping("/afficherAgence/{idAgence}")
    public Agence afficherAgenceById(@PathVariable Long idAgence) {
        return agenceService.afficherAgenceById(idAgence);
    }


}
