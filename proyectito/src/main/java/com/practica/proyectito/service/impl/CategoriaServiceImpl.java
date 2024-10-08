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

    @Override
    public Categorias saveCategorias(CategoriasDto categoriasDto) {
        Categorias categorias = mapToCategorias(categoriasDto);
        return categoriasRepository.save(categorias);
    }

    @Override
    public CategoriasDto findCategoriasById(Long categoriasId) {
        Categorias categorias = categoriasRepository.findById(categoriasId).get();
        return mapToCategoriasDto(categorias);
    }

    @Override
    public void updateCategorias(CategoriasDto categoriasDto) {
        Categorias categorias = mapToCategorias(categoriasDto);
        categoriasRepository.save(categorias);
    }

    @Override
    public void delete(Long categoriasId) {
        categoriasRepository.deleteById(categoriasId);
    }

    private Categorias mapToCategorias(CategoriasDto categorias) {
        Categorias categoriasDto = Categorias.builder()
                .id(categorias.getId())
                .nombre(categorias.getNombre())
                .descripcion(categorias.getDescripcion())
                .build();
        return categoriasDto;
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
