package com.practica.proyectito.service.impl;

import com.practica.proyectito.dto.ProveedoresDto;
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
