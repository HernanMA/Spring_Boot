package com.SpringMVC.SpringDia1.Service.impl;

import com.SpringMVC.SpringDia1.Dto.ProductoDTO;
import com.SpringMVC.SpringDia1.Model.Producto;
import com.SpringMVC.SpringDia1.Repository.ProductoRepository;
import com.SpringMVC.SpringDia1.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class ProductoServiceIMPL implements ProductoService {

    private ProductoRepository productoRepository;

    @Autowired
    public ProductoServiceIMPL(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<ProductoDTO> findAllProductos() {
        List<Producto> productos = productoRepository.findAll();
        return productos.stream().map((producto) -> mapToProductoDTO(producto)).collect(Collectors.toList());
    }

    private ProductoDTO mapToProductoDTO(Producto producto) {
        ProductoDTO productoDTO = ProductoDTO.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .precio(producto.getPrecio())
                .cantidad_en_stock(producto.getCantidad_en_stock())
                .dia_pedido(producto.getDia_pedido())
                .fotoProducto(producto.getFotoProducto())
                .build();
        return productoDTO;
    }

}
