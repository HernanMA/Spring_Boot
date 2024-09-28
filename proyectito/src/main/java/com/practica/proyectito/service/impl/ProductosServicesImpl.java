package com.practica.proyectito.service.impl;

import com.practica.proyectito.dto.ProductosDto;
import com.practica.proyectito.models.Productos;
import com.practica.proyectito.repository.ProductosRepository;
import com.practica.proyectito.service.ProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductosServicesImpl implements ProductoServices {

    private ProductosRepository productosRepository;

    @Autowired
    public  ProductosServicesImpl(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    @Override
    public List<ProductosDto> findAllProductos() {
        List<Productos> producto = productosRepository.findAll();
        return producto.stream().map((productos) -> mapToProductosDto(productos)).collect(Collectors.toList());
    }

    @Override
    public Productos saveProductos(Productos productos) {
        return productosRepository.save(productos);
    }

    private ProductosDto mapToProductosDto(Productos productos) {
        ProductosDto productosDto = ProductosDto.builder()
                .id(productos.getId())
                .nombre(productos.getNombre())
                .descripcion(productos.getDescripcion())
                .precio(productos.getPrecio())
                .cantidad_en_stock(productos.getCantidad_en_stock())
                .categoria_id(productos.getCategoria_id())
                .proveedor_id(productos.getProveedor_id())
                .build();
        return productosDto;
    }
}
