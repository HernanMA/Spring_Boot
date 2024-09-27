package com.practica.proyectito.controller;

import com.practica.proyectito.dto.CategoriasDto;
import com.practica.proyectito.service.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoriaController {

    private final CategoriasService categoriasService;

    @Autowired
    public CategoriaController(CategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }

    @GetMapping("/categorias")
    public String listCategorias(Model model) {
        List<CategoriasDto> categorias = categoriasService.findAllCategorias();
        model.addAttribute("categorias", categorias);
        return "categorias-list";
    }
}
