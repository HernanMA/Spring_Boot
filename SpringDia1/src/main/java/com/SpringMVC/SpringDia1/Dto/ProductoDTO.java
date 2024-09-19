package com.SpringMVC.SpringDia1.Dto;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class ProductoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private int cantidad_en_stock;
    private LocalDateTime dia_pedido;
    private String fotoProducto;
}
