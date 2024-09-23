package com.RestaurantManagement.restaurantManagement.service;

import  com.RestaurantManagement.restaurantManagement.repository.PlatillosRepository;
import com.RestaurantManagement.restaurantManagement.model.Platillos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatillosService {

    @Autowired
    private PlatillosRepository platillosRepository;

    public List<Platillos> findAll(){
        return platillosRepository.findAll();
    }

    public Platillos finById(Long id){
        return platillosRepository.findById(id).orElse(null);
    }

    public Platillos save(Platillos platillos){
        return platillosRepository.save(platillos);
    }

    public Platillos update(Long id,Platillos platillos){
        Platillos uPlatillo = platillosRepository.findById(id).orElse(null);
        uPlatillo.setId(platillos.getId());
        uPlatillo.setName(platillos.getName());
        uPlatillo.setPrice(platillos.getPrice());
        uPlatillo.setEnable(platillos.getEnable());

        return platillosRepository.save(uPlatillo);
    }

    public void delete(Long id){
        platillosRepository.deleteById(id);
    }
}
