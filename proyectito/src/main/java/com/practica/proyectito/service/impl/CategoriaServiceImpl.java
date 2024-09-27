package com.practica.proyectito.service.impl;

import com.practica.proyectito.dto.CategoriasDto;
import com.practica.proyectito.dto.ProductosDto;
import com.practica.proyectito.models.Categorias;
import com.practica.proyectito.repository.CategoriasRepository;
import com.practica.proyectito.service.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriasService {

    private CategoriasRepository categoriasRepository;

    @Autowired
    public CategoriaServiceImpl(CategoriasRepository categoriasRepository) {
        this.categoriasRepository = categoriasRepository;
    }

    @Override
    public List<CategoriasDto> findAllCategorias() {
        List<Categorias> categoria = categoriasRepository.findAll();
        return categoria.stream().map((categorias) -> mapToCategoriasDto(categorias)).collect(Collectors.toList());
    }

    private CategoriasDto mapToCategoriasDto(Categorias categorias) {
        CategoriasDto categoriasDto = CategoriasDto.builder()
                .id(categorias.getId())
                .nombre(categorias.getNombre())
                .descripcion(categorias.getDescripcion())
                .build();
        return categoriasDto;
    }
}
