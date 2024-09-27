package com.practica.proyectito.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class MovimientosInventarioDto {
    private Long id;
    private int producto_id;
    private LocalDateTime fecha;
    private int cantidad;
    private String tipo_movimiento;
}
