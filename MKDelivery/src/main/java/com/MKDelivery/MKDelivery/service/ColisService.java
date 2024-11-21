package com.MKDelivery.MKDelivery.service;

import com.MKDelivery.MKDelivery.model.Colis;
import com.MKDelivery.MKDelivery.repository.ColisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColisService {
    @Autowired
    private ColisRepository repository;

    public List<Colis> getAllColis() {
        return repository.findAll();
    }

    public List<Colis> getColisByCategorie(String categorie) {
        return repository.findByCategorie(categorie);
    }

    public Colis getColisById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Colis non trouvé avec l'id : " + id));
    }

    public Colis createColis(Colis colis) {
        return repository.save(colis);
    }

    public Colis updateColis(Long id, Colis colisDetails) {
        Colis colis = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Colis non trouvé avec l'id : " + id));

        colis.setNom(colisDetails.getNom());
        colis.setDescription(colisDetails.getDescription());
        colis.setCategorie(colisDetails.getCategorie());
        colis.setPoids(colisDetails.getPoids());

        return repository.save(colis);
    }

    public void deleteColis(Long id) {
        repository.deleteById(id);
    }
}
