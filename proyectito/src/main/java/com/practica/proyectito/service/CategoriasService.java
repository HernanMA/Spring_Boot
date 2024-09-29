package com.practica.proyectito.service;

import com.practica.proyectito.dto.CategoriasDto;
import com.practica.proyectito.models.Categorias;
import com.practica.proyectito.models.Productos;

import java.util.List;

public interface CategoriasService {
    List<CategoriasDto> findAllCategorias();
    Categorias saveCategorias(Categorias categorias);

    CategoriasDto findCategoriasById(Long categoriasId);

    void updateCategorias(CategoriasDto categorias);
}
