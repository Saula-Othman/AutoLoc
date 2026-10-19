package tn.esprit.autoloc.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.IReservationService;

import java.util.List;

@RestController
@Tag(name = "Réservations", description = "Gestion des réservations")
@AllArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {

    private final IReservationService reservationService;

    @Operation(summary = "Ajouter une réservation")
    @PostMapping("/ajouterReservation")
    public Reservation ajouterReservation(@RequestBody Reservation reservation) {
        return reservationService.ajouterReservation(reservation);
    }

    @Operation(summary = "Modifier une réservation")
    @PutMapping("/modifierReservation")
    public Reservation modifierReservation(@RequestBody Reservation reservation) {
        return reservationService.modifierReservation(reservation);
    }

    @Operation(summary = "Lister les réservations")
    @GetMapping("/afficherToutesReservations")
    public List<Reservation> afficherToutesReservations() {
        return reservationService.afficherToutesReservations();
    }

    @Operation(summary = "Afficher une réservation")
    @GetMapping("/afficherReservation/{idReservation}")
    public Reservation afficherReservationById(@PathVariable Long idReservation) {
        return reservationService.afficherReservationById(idReservation);
    }

    @Operation(summary = "Supprimer une réservation")
    @DeleteMapping("/supprimerReservation/{idReservation}")
    public void supprimerReservation(@PathVariable Long idReservation) {
        reservationService.supprimerReservation(idReservation);
    }
}
