package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Employe;

import java.util.List;

public interface IEmployeService {

    Employe ajouterEmploye(Employe employe);

    Employe modifierEmploye(Employe employe);

    List<Employe> afficherToutesEmployes();

    Employe afficherEmployeById(Long id);

    void supprimerEmploye(long id);

    Employe desaffecterEmploye(Long idEmploye);

    Employe affecterEmploye(Long idEmploye, Long idAgence);

    


}
