package com.springboot.myproject.domain.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Productos {
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private int cantidad_en_stock;
    private LocalDateTime dia_pedido;
    private String fotoProducto;

    public Productos(Long id, String nombre, String descripcion, BigDecimal precio, int cantidad_en_stock, String fotoProducto) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad_en_stock = cantidad_en_stock;
        this.fotoProducto = fotoProducto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getCantidad_en_stock() {
        return cantidad_en_stock;
    }

    public void setCantidad_en_stock(int cantidad_en_stock) {
        this.cantidad_en_stock = cantidad_en_stock;
    }

    public LocalDateTime getDia_pedido() {
        return dia_pedido;
    }

    public void setDia_pedido(LocalDateTime dia_pedido) {
        this.dia_pedido = dia_pedido;
    }

    public String getFotoProducto() {
        return fotoProducto;
    }

    public void setFotoProducto(String fotoProducto) {
        this.fotoProducto = fotoProducto;
    }
}
