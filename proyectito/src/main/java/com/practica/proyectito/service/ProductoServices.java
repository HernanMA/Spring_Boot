package com.practica.proyectito.service;

import com.practica.proyectito.dto.ProductosDto;
import com.practica.proyectito.models.Productos;

import java.util.List;

public interface ProductoServices {
    List<ProductosDto> findAllProductos();
    Productos saveProductos(ProductosDto productosDto);

    ProductosDto findProductosById(Long productosId);

    void updateProducto(ProductosDto productos);
}
