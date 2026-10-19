package tn.esprit.autoloc.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@Tag(name = "Paiements", description = "Gestion des paiements")
@AllArgsConstructor
@RequestMapping("/paiements")
public class PaiementController {

    private final IPaiementService paiementService;

    @Operation(summary = "Ajouter un paiement", description = "Crée un paiement")
    @PostMapping("/ajouterPaiement")
    public Paiement ajouterPaiement(@RequestBody Paiement paiement) {
        return paiementService.ajouterPaiement(paiement);
    }

    @Operation(summary = "Modifier un paiement", description = "Modifier un paiement")
    @PutMapping("/modifierPaiement")
    public Paiement modifierPaiement(@RequestBody Paiement paiement) {
        return paiementService.modifierPaiement(paiement);
    }

    @Operation(summary = "Lister les paiements", description = "Afficher la liste de tous les paiements")
    @GetMapping("/afficherToutesPaiements")
    public List<Paiement> afficherToutesPaiements() {
        return paiementService.afficherToutesPaiements();
    }

    @Operation(summary = "Afficher un paiement", description = "Afficher un paiement selon son id")
    @GetMapping("/afficherPaiement/{idPaiement}")
    public Paiement afficherPaiementById(@PathVariable Long idPaiement) {
        return paiementService.afficherPaiementById(idPaiement);
    }

    @Operation(summary = "Supprimer un paiement", description = "Supprime un paiement selon son id")
    @DeleteMapping("/supprimerPaiement/{idPaiement}")
    public void supprimerPaiement(@PathVariable Long idPaiement) {
        paiementService.supprimerPaiement(idPaiement);
    }
}
