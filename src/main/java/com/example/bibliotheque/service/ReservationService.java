package com.example.bibliotheque.service;

import com.example.bibliotheque.model.Reservation;
import com.example.bibliotheque.model.ReservationRequest;
import com.example.bibliotheque.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public boolean reserverLivreViaSoap(ReservationRequest request) {
        Reservation reservation = new Reservation();
        reservation.setLivreId(request.getLivreId());
        reservation.setUtilisateur(request.getUtilisateur());
        reservation.setDateDebut(request.getDateDebut());
        reservation.setDateFin(request.getDateFin());
        reservationRepository.save(reservation);
        return true;
    }

    public Optional<Reservation> getReservationById(Long id) {
        return reservationRepository.findById(id);
    }
}
