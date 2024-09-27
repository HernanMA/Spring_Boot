package com.practica.proyectito.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductosDto {
    private long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private int cantidad_en_stock;
    private int categoria_id;
    private int proveedor_id;
}
