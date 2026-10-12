package tn.esprit.autoloc.Controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/clients")
public class ClientController {

    private final IClientService clientService;

    @GetMapping("/afficherToutesClients")
    public List<Client> afficherToutesClients() {
        return clientService.afficherToutesClients();
    }

    @GetMapping("/afficherClients/{idClient}")
    public Client afficherClientById(@PathVariable Long idClient) {
        return clientService.afficherClientById(idClient);
    }

    @DeleteMapping("/supprimerClient/{idClient}")
    public void supprimerClient(@PathVariable Long idClient) {
        clientService.supprimerClient(idClient);
    }

    @PostMapping("/ajouterClient")
    public Client ajouterClient(@RequestBody Client client) {
        return clientService.ajouterClient(client);
    }

    @PutMapping("/modifierClient")
    public Client modifierClient(@RequestBody Client client) {
        return clientService.modifierClient(client);
    }


}

