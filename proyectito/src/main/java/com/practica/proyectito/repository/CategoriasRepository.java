package com.practica.proyectito.repository;

import com.practica.proyectito.models.Categorias;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriasRepository extends JpaRepository<Categorias, Long> {
    Optional<Categorias> findByNombre(String url);
}
