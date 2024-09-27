package com.practica.proyectito.repository;

import com.practica.proyectito.models.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductosRepository extends JpaRepository<Productos, Long> {
    Optional<ProductosRepository> findByNombre(String url);
}
