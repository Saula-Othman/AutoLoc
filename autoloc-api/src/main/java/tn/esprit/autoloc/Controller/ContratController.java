package tn.esprit.autoloc.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;

@RestController
@Tag(name = "Contrats", description = "Gestion des contrats")
@AllArgsConstructor
@RequestMapping("/contrats")
public class ContratController {


    private final IContratService contratService;
    @Operation(summary = "Ajouter un contrat", description = "Crée un contrat")
    @PostMapping("/ajouterContrats")
    public Contrat ajouterContrat(@RequestBody Contrat contrat) {
        return contratService.ajouterContrat(contrat);
    }

    @Operation(summary = "Modifier un contrat", description = "Modifier un contrat")
    @PutMapping("/modifierContrats")
    public Contrat modifierContrat(@RequestBody Contrat contrat) {
        return contratService.modifierContrat(contrat);
    }

    @Operation(summary = "Lister les contrats", description = "Afficher la liste de tous les contrats")
    @GetMapping("/afficherToutesContrats")
    public List<Contrat> afficherToutesContrats() {
        return contratService.afficherToutesContrat();
    }

    @Operation(summary = "Afficher un contrat", description = "Afficher un contrat selon son id")
    @GetMapping("/afficherContrats/{idContrat}")
    public Contrat affichercontratById(@PathVariable long idContrat) {
        return contratService.afficherContratById(idContrat);
    }

    @Operation(summary = "Supprimer un contrat", description = "Supprime un contrat selon son id")
    @DeleteMapping("/supprimerContrats/{idContrat}")
    public void supprimerContrat(@PathVariable long idContrat) {
        contratService.supprimerContrat(idContrat);
    }


}
