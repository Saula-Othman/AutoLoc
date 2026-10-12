package tn.esprit.autoloc.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/contrats")
public class ContratController {


    private final IContratService contratService;

    @GetMapping("/afficherToutesContrats")
    public List<Contrat> afficherToutesContrats() {
        return contratService.afficherToutesContrat();
    }


    @GetMapping("/afficherContrats/{idContrat}")
    public Contrat affichercontratById(@PathVariable long idContrat) {
        return contratService.afficherContratById(idContrat);
    }


    @PostMapping("/ajouterContrats")
    public Contrat ajouterContrat(@RequestBody Contrat contrat) {
        return contratService.ajouterContrat(contrat);
    }

    @PutMapping("/modifierContrats")
    public Contrat modifierContrat(@RequestBody Contrat contrat) {
        return contratService.modifierContrat(contrat);
    }

    @DeleteMapping("/supprimerContrats/{idContrat}")
    public void supprimerContrat(@PathVariable long idContrat) {
        contratService.supprimerContrat(idContrat);
    }


}
