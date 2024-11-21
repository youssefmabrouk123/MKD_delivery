package com.MKDelivery.MKDelivery.controller;

import com.MKDelivery.MKDelivery.model.Colis;
import com.MKDelivery.MKDelivery.service.ColisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colis")
public class ColisController {
    @Autowired
    private ColisService service;

    @GetMapping
    public List<Colis> getAllColis() {
        return service.getAllColis();
    }

    @GetMapping("/categorie/{categorie}")
    public List<Colis> getColisByCategorie(@PathVariable String categorie) {
        return service.getColisByCategorie(categorie);
    }

    @GetMapping("/{id}")
    public Colis getColisById(@PathVariable Long id) {
        return service.getColisById(id);
    }

    @PostMapping
    public Colis createColis(@RequestBody Colis colis) {
        return service.createColis(colis);
    }

    @PutMapping("/{id}")
    public Colis updateColis(@PathVariable Long id, @RequestBody Colis colisDetails) {
        return service.updateColis(id, colisDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteColis(@PathVariable Long id) {
        service.deleteColis(id);
    }
}
