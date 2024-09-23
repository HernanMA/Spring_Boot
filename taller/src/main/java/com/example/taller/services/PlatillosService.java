package com.RestaurantManagement.restaurantManagement.service;

import  com.RestaurantManagement.restaurantManagement.repository.PlatillosRepository;
import com.RestaurantManagement.restaurantManagement.model.Platillos;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatillosService {
    @Autowired
    private PlatillosRepository platillosRepository;

    public List<Platillos> findAll() {
        return platillosRepository.findAll();
    }

    public Optional<Platillos> findById(Long id) {
        return platillosRepository.findById(id);
    }

    public Platillos save(Platillos platillo) {
        return platillosRepository.save(platillo);
    }

    public void delete(Long id) {
        platillosRepository.deleteById(id);
    }
}


