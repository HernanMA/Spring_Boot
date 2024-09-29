package com.practica.proyectito.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProveedoresDto {
    private Long id;
    @NotEmpty(message = "El nombre no debe estar vacio")
    private String nombre;
    @NotEmpty(message = "El telefono no debe estar vacio")
    private String telefono;
    @NotEmpty(message = "El email no debe estar vacio")
    @Email(message = "El email debe ser válido")
    private String email;
    @NotEmpty(message = "La dirección no debe estar vacia")
    private String direccion;
}
