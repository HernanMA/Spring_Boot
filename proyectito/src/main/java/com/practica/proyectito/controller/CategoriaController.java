package com.practica.proyectito.controller;

import com.practica.proyectito.dto.CategoriasDto;
import com.practica.proyectito.models.Categorias;
import com.practica.proyectito.service.CategoriasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/categorias/new")
    public String createCategoriasForm(Model model) {
        Categorias categorias = new Categorias();
        model.addAttribute("categorias", categorias);
        return "categorias-create";
    }

    @PostMapping("/categorias/new")
    public String saveCategorias(@Valid @ModelAttribute("categorias") CategoriasDto categoriasDto,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categorias", categoriasDto);
            return "categorias-create";
        }
        categoriasService.saveCategorias(categoriasDto);
        return "redirect:/categorias";
    }

    @GetMapping("/categorias/{categoriasId}/edit")
    public String editCategoriasForm(@PathVariable("categoriasId") Long categoriasId, Model model) {
        CategoriasDto categorias = categoriasService.findCategoriasById(categoriasId);
        model.addAttribute("categorias", categorias);
        return "categorias-edit";
    }

    @PostMapping("/categorias/{categoriasId}/edit")
    public String updateCategorias(@PathVariable("categoriasId") Long categoriasId,
                                   @Valid @ModelAttribute("categorias") CategoriasDto categorias,
                                   BindingResult result) {
        if (result.hasErrors()) {
            return "categorias-edit";
        }
        categorias.setId(categoriasId);
        categoriasService.updateCategorias(categorias);
        return "redirect:/categorias";
    }
}
