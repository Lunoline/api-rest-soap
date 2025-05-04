package com.example.bibliotheque.service;

import com.example.bibliotheque.model.Livre;
import com.example.bibliotheque.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    public Optional<Livre> getLivreById(Long id) {
        return livreRepository.findById(id);
    }

    public List<Livre> getLivresDisponibles() {
        return livreRepository.findByDisponibleTrue();
    }
}
