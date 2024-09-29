package com.practica.proyectito.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoriasDto {
    private Long id;
    @NotEmpty(message = "El nombre no debe estar vacio")
    private String nombre;
    @NotEmpty(message = "La descripcion no debe estar sin imagen")
    private String descripcion;
}
