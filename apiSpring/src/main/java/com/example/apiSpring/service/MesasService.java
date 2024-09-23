package com.RestaurantManagement.restaurantManagement.service;

import com.RestaurantManagement.restaurantManagement.model.Mesas;
import com.RestaurantManagement.restaurantManagement.repository.MesasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesasService {

    @Autowired
    private MesasRepository mesasRepository;

    public List<Mesas> findAll(){
        return mesasRepository.findAll();
    }

    public Mesas findById(Long id){
        return mesasRepository.findById(id).orElse(null);
    }

    public Mesas save(Mesas mesas){
        return mesasRepository.save(mesas);
    }

    public Mesas update(Long id, Mesas mesas){
        Mesas uMesas = mesasRepository.findById(id).orElseThrow();
        uMesas.setId(mesas.getId());
        uMesas.setNumberTable(mesas.getNumberTable());
        uMesas.setBusy(mesas.getBusy());

        return mesasRepository.save(uMesas);
    }

    public void delete(Long id){
        mesasRepository.deleteById(id);
    }
}
