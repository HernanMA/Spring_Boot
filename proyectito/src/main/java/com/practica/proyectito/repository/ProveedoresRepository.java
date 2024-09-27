package com.practica.proyectito.repository;

import com.practica.proyectito.models.Proveedores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProveedoresRepository extends JpaRepository<Proveedores, Long> {
    Optional<Proveedores> findByNombre(String url);
}
