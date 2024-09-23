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
    public List<Mesas> getAllMesas(){
        return mesasService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mesas> getByIdMesas(@PathVariable Long id){
        Mesas mesa = mesasService.findById(id);
        return ResponseEntity.ok(mesa);
    }

    @PostMapping
    public Mesas createMesas(@RequestBody Mesas mesa){
        return mesasService.save(mesa);
    }

    @PutMapping("/{id}")
    public Mesas updateMesas(@PathVariable Long id, @RequestBody Mesas mesa){
        Mesas uMesas = mesasService.findById(id);
        if(uMesas != null){
            uMesas.setNumberTable(mesa.getNumberTable());
            uMesas.setBusy(mesa.getBusy());
            return mesasService.save(uMesas);
        }else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteMesas(@PathVariable Long id){
        mesasService.delete(id);
    }
}
