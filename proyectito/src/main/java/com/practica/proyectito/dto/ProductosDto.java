package com.practica.proyectito.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductosDto {
    private Long id;
    @NotEmpty(message = "El nombre no debe estar vacio")
    private String nombre;
    @NotEmpty(message = "Debe haber una descripción valida")
    private String descripcion;
    @NotNull(message = "El precio no debe estar vacio")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private BigDecimal precio;
    @NotNull(message = "Debe haber una cantidad en stock")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private int cantidad_en_stock;
    @NotNull(message = "Debe haber un id de categoria")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private Integer categoria_id;
    @NotNull(message = "Debe haber un id de proveedor")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private Integer proveedor_id;
}
