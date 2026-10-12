package tn.esprit.autoloc.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/agences")
public class AgenceController {

    private final IAgenceService agenceService;

    @GetMapping("/afficherToutesAgences")
    public List<Agence> getALLAgences() {
        return agenceService.afficherToutesAgences();
    }

    @PostMapping("/ajouterAgences")
    public Agence ajouterAgence(@RequestBody Agence agence) {
        return agenceService.ajouterAgence(agence);
    }

    @PutMapping("/modifierAgences")
    public Agence modifierAgence(@RequestBody Agence agence) {
        return agenceService.modifierAgence(agence);
    }

    @DeleteMapping("/supprimerAgence/{idAgence}")
    public void supprimerAgence(@PathVariable Long idAgence) {
        agenceService.supprimerAgence(idAgence);
    }

    @GetMapping("/afficherAgence/{idAgence}")
    public Agence afficherAgenceById(@PathVariable Long idAgence) {
        return agenceService.afficherAgenceById(idAgence);
    }


}
