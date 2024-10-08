package com.practica.proyectito.service;

import com.practica.proyectito.dto.ProveedoresDto;
import com.practica.proyectito.models.Proveedores;

import java.util.List;

public interface ProveedoresServices {
    List<ProveedoresDto> findAllProveedores();
    Proveedores saveProveedores(ProveedoresDto proveedoresDto);

    ProveedoresDto findProveedoresById(Long proveedoresId);

    void updateProveedores(ProveedoresDto proveedores);

    void delete(Long proveedoresId);
}
