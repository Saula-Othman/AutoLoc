package tn.esprit.autoloc.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.IReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {

    private final IReservationService reservationService;

    @GetMapping("/afficherToutesReservations")
    public List<Reservation> afficherToutesReservations() {
        return reservationService.afficherToutesReservations();
    }

    @GetMapping("/afficherReservation/{idReservation}")
    public Reservation afficherReservationById(@PathVariable Long idReservation) {
        return reservationService.afficherReservationById(idReservation);
    }

    @PostMapping("/ajouterReservation")
    public Reservation ajouterReservation(@RequestBody Reservation reservation) {
        return reservationService.ajouterReservation(reservation);
    }

    @PutMapping("/modifierReservation")
    public Reservation modifierReservation(@RequestBody Reservation reservation) {
        return reservationService.modifierReservation(reservation);
    }

    @DeleteMapping("/supprimerReservation/{idReservation}")
    public void supprimerReservation(@PathVariable Long idReservation) {
        reservationService.supprimerReservation(idReservation);
    }
}
