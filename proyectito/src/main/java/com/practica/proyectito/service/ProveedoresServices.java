package com.practica.proyectito.service;

import com.practica.proyectito.dto.ProveedoresDto;
import com.practica.proyectito.models.Proveedores;

import java.util.List;

public interface ProveedoresServices {
    List<ProveedoresDto> findAllProveedores();
    Proveedores saveProveedores(Proveedores proveedores);
}
