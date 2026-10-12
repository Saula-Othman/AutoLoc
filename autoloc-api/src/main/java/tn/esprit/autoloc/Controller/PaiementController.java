package tn.esprit.autoloc.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/paiements")
public class PaiementController {

    private final IPaiementService paiementService;

    @GetMapping("/afficherToutesPaiements")
    public List<Paiement> afficherToutesPaiements() {
        return paiementService.afficherToutesPaiements();
    }

    @GetMapping("/afficherPaiement/{idPaiement}")
    public Paiement afficherPaiementById(@PathVariable Long idPaiement) {
        return paiementService.afficherPaiementById(idPaiement);
    }

    @PostMapping("/ajouterPaiement")
    public Paiement ajouterPaiement(@RequestBody Paiement paiement) {
        return paiementService.ajouterPaiement(paiement);
    }

    @PutMapping("/modifierPaiement")
    public Paiement modifierPaiement(@RequestBody Paiement paiement) {
        return paiementService.modifierPaiement(paiement);
    }

    @DeleteMapping("/supprimerPaiement/{idPaiement}")
    public void supprimerPaiement(@PathVariable Long idPaiement) {
        paiementService.supprimerPaiement(idPaiement);
    }
}
