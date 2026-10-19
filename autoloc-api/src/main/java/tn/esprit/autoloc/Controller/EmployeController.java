package tn.esprit.autoloc.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@Tag(name = "Employés", description = "Gestion des employés")
@AllArgsConstructor
@RequestMapping("/employes")
public class EmployeController {

    private final IEmployeService employeService;


    @Operation(summary = "Ajouter un employé")
    @PostMapping("/ajouterEmploye")
    public Employe ajouterEmploye(@RequestBody Employe employe) {
        return employeService.ajouterEmploye(employe);
    }


    @Operation(summary = "Modifier un employé")
    @PutMapping("/modifierEmploye")
    public Employe modifierEmploye(@RequestBody Employe employe) {
        return employeService.modifierEmploye(employe);
    }


    @Operation(summary = "Lister les employés")
    @GetMapping("/afficherToutesEmployes")
    public List<Employe> afficherToutesEmployes() {
        return employeService.afficherToutesEmployes();
    }

    @Operation(summary = "Afficher un employé")
    @GetMapping("/afficherEmploye/{idEmploye}")
    public Employe afficherEmployeById(@PathVariable Long idEmploye) {
        return employeService.afficherEmployeById(idEmploye);
    }

    @Operation(summary = "Supprimer un employé")
    @DeleteMapping("/supprimerEmploye/{idEmploye}")
    public void supprimerEmploye(@PathVariable Long idEmploye) {
        employeService.supprimerEmploye(idEmploye);
    }
}