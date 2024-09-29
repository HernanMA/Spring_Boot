package com.practica.proyectito.service.impl;

import com.practica.proyectito.dto.ProductosDto;
import com.practica.proyectito.dto.ProveedoresDto;
import com.practica.proyectito.models.Productos;
import com.practica.proyectito.models.Proveedores;
import com.practica.proyectito.repository.ProveedoresRepository;
import com.practica.proyectito.service.ProveedoresServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProveedoresServicesImpl implements ProveedoresServices {

    private ProveedoresRepository proveedoresRepository;

    @Autowired
    public ProveedoresServicesImpl(ProveedoresRepository proveedoresRepository) {
        this.proveedoresRepository = proveedoresRepository;
    }

    @Override
    public List<ProveedoresDto> findAllProveedores() {
        List<Proveedores> proveedor = proveedoresRepository.findAll();
        return proveedor.stream().map((proveedores) -> mapToProveedoresDto(proveedores)).collect(Collectors.toList());
    }

    @Override
    public Proveedores saveProveedores(Proveedores proveedores) {
        return proveedoresRepository.save(proveedores);
    }

    @Override
    public ProveedoresDto findProveedoresById(Long proveedoresId) {
        Proveedores proveedores = proveedoresRepository.findById(proveedoresId).get();
        return mapToProveedoresDto(proveedores);
    }

    @Override
    public void updateProveedores(ProveedoresDto proveedoresDto) {
        Proveedores proveedores = mapToProveedoresDto(proveedoresDto);
        proveedoresRepository.save(proveedores);
    }

    private Proveedores mapToProveedoresDto(ProveedoresDto proveedores) {
        Proveedores proveedoresDto = Proveedores.builder()
                .id(proveedores.getId())
                .nombre(proveedores.getNombre())
                .telefono(proveedores.getTelefono())
                .email(proveedores.getEmail())
                .direccion(proveedores.getDireccion())
                .build();
        return proveedoresDto;
    }

    private ProveedoresDto mapToProveedoresDto(Proveedores proveedores) {
        ProveedoresDto proveedoresDto = ProveedoresDto.builder()
                .id(proveedores.getId())
                .nombre(proveedores.getNombre())
                .telefono(proveedores.getTelefono())
                .email(proveedores.getEmail())
                .direccion(proveedores.getDireccion())
                .build();
        return proveedoresDto;
    }
}
