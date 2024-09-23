package com.RestaurantManagement.restaurantManagement.controller;

import com.RestaurantManagement.restaurantManagement.model.Mesas;
import com.RestaurantManagement.restaurantManagement.service.MesasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mesas")
public class MesasController {

    @Autowired
    private MesasService mesasService;

    @GetMapping
    public ResponseEntity<List<Mesas>> getAllMesas() {
        List<Mesas> mesasList = mesasService.findAll();
        return ResponseEntity.ok(mesasList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mesas> getByIdMesas(@PathVariable Long id) {
        return mesasService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mesas> createMesas(@RequestBody Mesas mesa) {
        Mesas newMesa = mesasService.save(mesa);
        return ResponseEntity.status(201).body(newMesa); 
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mesas> updateMesas(@PathVariable Long id, @RequestBody Mesas mesa) {
        return mesasService.findById(id)
                .map(existingMesa -> {
                    existingMesa.setNumberTable(mesa.getNumberTable());
                    existingMesa.setBusy(mesa.getBusy());
                    Mesas updatedMesa = mesasService.save(existingMesa);
                    return ResponseEntity.ok(updatedMesa);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMesas(@PathVariable Long id) {
        if (mesasService.findById(id).isPresent()) {
            mesasService.delete(id);
            return ResponseEntity.noContent().build(); 
        } else {
            return ResponseEntity.notFound().build(); 
        }
    }
}
