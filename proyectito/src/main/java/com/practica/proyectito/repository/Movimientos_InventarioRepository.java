package com.practica.proyectito.repository;

import com.practica.proyectito.models.Movimientos_Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Movimientos_InventarioRepository extends JpaRepository<Movimientos_Inventario, Long> {
    Optional<Movimientos_Inventario> findById(Long id);
}
