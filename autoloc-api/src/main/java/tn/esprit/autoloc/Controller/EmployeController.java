package tn.esprit.autoloc.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/employes")
public class EmployeController {

    private final IEmployeService employeService;

    @GetMapping("/afficherToutesEmployes")
    public List<Employe> afficherToutesEmployes() {
        return employeService.afficherToutesEmployes();
    }

    @GetMapping("/afficherEmploye/{idEmploye}")
    public Employe afficherEmployeById(@PathVariable Long idEmploye) {
        return employeService.afficherEmployeById(idEmploye);
    }

    @PostMapping("/ajouterEmploye")
    public Employe ajouterEmploye(@RequestBody Employe employe) {
        return employeService.ajouterEmploye(employe);
    }

    @PutMapping("/modifierEmploye")
    public Employe modifierEmploye(@RequestBody Employe employe) {
        return employeService.modifierEmploye(employe);
    }

    @DeleteMapping("/supprimerEmploye/{idEmploye}")
    public void supprimerEmploye(@PathVariable Long idEmploye) {
        employeService.supprimerEmploye(idEmploye);
    }
}