package com.MKDelivery.MKDelivery.repository;

import com.MKDelivery.MKDelivery.model.Colis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColisRepository extends JpaRepository<Colis, Long> {
    List<Colis> findByCategorie(String categorie);
}
