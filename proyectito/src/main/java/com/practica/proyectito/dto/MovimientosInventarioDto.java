package com.practica.proyectito.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class MovimientosInventarioDto {
    private Long id;
    private int producto_id;
    @NotNull(message = "Debe haber una fecha valida YYYY/MM/DD")
    private LocalDate fecha;
    @NotNull(message = "Debe haber una cantidad")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private int cantidad;
    private String tipo_movimiento;
}
