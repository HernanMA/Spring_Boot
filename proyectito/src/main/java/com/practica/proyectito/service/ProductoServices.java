package com.practica.proyectito.service;

import com.practica.proyectito.dto.ProductosDto;

import java.util.List;

public interface ProductoServices {
    List<ProductosDto> findAllProductos();
}
