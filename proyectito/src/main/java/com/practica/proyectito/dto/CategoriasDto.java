package com.practica.proyectito.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoriasDto {
    private Long id;
    private String nombre;
    private String descripcion;
}
