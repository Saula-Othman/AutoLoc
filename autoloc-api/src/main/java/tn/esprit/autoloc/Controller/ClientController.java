package tn.esprit.autoloc.Controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@RestController
@Tag(name = "Clients", description = "Gestion des clients")
@AllArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private final IClientService clientService;

    @Operation(summary = "Lister les clients")
    @GetMapping("/afficherToutesClients")
    public List<Client> afficherToutesClients() {
        return clientService.afficherToutesClients();
    }

    @Operation(summary = "Afficher un client")
    @GetMapping("/afficherClients/{idClient}")
    public Client afficherClientById(@PathVariable Long idClient) {
        return clientService.afficherClientById(idClient);
    }

    @Operation(summary = "Supprimer un client")
    @DeleteMapping("/supprimerClient/{idClient}")
    public void supprimerClient(@PathVariable Long idClient) {
        clientService.supprimerClient(idClient);
    }

    @Operation(summary = "Ajouter un client")
    @PostMapping("/ajouterClient")
    public Client ajouterClient(@RequestBody Client client) {
        return clientService.ajouterClient(client);
    }

    @Operation(summary = "Modifier un client")
    @PutMapping("/modifierClient")
    public Client modifierClient(@RequestBody Client client) {
        return clientService.modifierClient(client);
    }


}

