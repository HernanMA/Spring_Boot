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
    public List<Platillos> getAllPlatillos(){
        return platillosService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Platillos> getByIdPlatillos(@PathVariable Long id){
        Platillos platillos = platillosService.finById(id);
        return ResponseEntity.ok(platillos);
    }

    @PostMapping
    public Platillos createPlatillos(@RequestBody Platillos platillo){
        return platillosService.save(platillo);
    }

    @PutMapping("/{id}")
    public Platillos updatePlatilos(@PathVariable Long id, @RequestBody Platillos platillos){
        Platillos uPlatillo = platillosService.finById(id);
        if(uPlatillo != null){
            uPlatillo.setPrice(platillos.getPrice());
            uPlatillo.setName(platillos.getName());
            uPlatillo.setEnable(platillos.getEnable());
            return platillosService.save(uPlatillo);
        }else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deletePlatillos(@PathVariable Long id){
        platillosService.delete(id);
    }
}
