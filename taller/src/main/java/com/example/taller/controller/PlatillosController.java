package com.RestaurantManagement.restaurantManagement.controller;

import com.RestaurantManagement.restaurantManagement.model.Mesas;
import com.RestaurantManagement.restaurantManagement.model.Platillos;
import com.RestaurantManagement.restaurantManagement.service.PlatillosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/platillos")
public class PlatillosController {

    @Autowired
    private PlatillosService platillosService;

    @GetMapping
    public ResponseEntity<List<Platillos>> getAllPlatillos() {
        List<Platillos> platillosList = platillosService.findAll();
        return ResponseEntity.ok(platillosList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Platillos> getByIdPlatillos(@PathVariable Long id) {
        return platillosService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Platillos> createPlatillos(@RequestBody Platillos platillo) {
        Platillos newPlatillo = platillosService.save(platillo);
        return ResponseEntity.status(201).body(newPlatillo); 
    }

    @PutMapping("/{id}")
    public ResponseEntity<Platillos> updatePlatillos(@PathVariable Long id, @RequestBody Platillos platillos) {
        return platillosService.findById(id)
                .map(existingPlatillo -> {
                    existingPlatillo.setPrice(platillos.getPrice());
                    existingPlatillo.setName(platillos.getName());
                    existingPlatillo.setEnable(platillos.getEnable());
                    Platillos updatedPlatillo = platillosService.save(existingPlatillo);
                    return ResponseEntity.ok(updatedPlatillo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlatillos(@PathVariable Long id) {
        if (platillosService.findById(id).isPresent()) {
            platillosService.delete(id);
            return ResponseEntity.noContent().build(); 
        } else {
            return ResponseEntity.notFound().build(); 
        }
    }
}

