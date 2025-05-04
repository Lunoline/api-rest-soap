package com.example.bibliotheque.controller;

import com.example.bibliotheque.model.Reservation;
import com.example.bibliotheque.model.ReservationRequest;
import com.example.bibliotheque.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id) {
        Optional<Reservation> reservation = reservationService.getReservationById(id);
        return reservation.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> reserverLivre(@RequestBody ReservationRequest request) {
        boolean success = reservationService.reserverLivreViaSoap(request);
        if (success) {
            return ResponseEntity.ok("Réservation effectuée avec succès !");
        } else {
            return ResponseEntity.badRequest().body("Échec de la réservation");
        }
    }
}
