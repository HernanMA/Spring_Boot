package com.practica.proyectito.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProveedoresDto {
    private Long id;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;
}
