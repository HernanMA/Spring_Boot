package com.RestaurantManagement.restaurantManagement.service;

import com.RestaurantManagement.restaurantManagement.model.Mesas;
import com.RestaurantManagement.restaurantManagement.repository.MesasRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesasService {
    @Autowired
    private MesasRepository mesasRepository;

    public List<Mesas> findAll() {
        return mesasRepository.findAll();
    }

    public Optional<Mesas> findById(Long id) {
        return mesasRepository.findById(id);
    }

    public Mesas save(Mesas mesa) {
        return mesasRepository.save(mesa);
    }

    public void delete(Long id) {
        mesasRepository.deleteById(id);
    }
}

