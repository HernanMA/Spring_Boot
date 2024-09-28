package com.practica.proyectito.controller;

import com.practica.proyectito.dto.ProveedoresDto;
import com.practica.proyectito.models.Proveedores;
import com.practica.proyectito.service.ProveedoresServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProveedoresController {

    private final ProveedoresServices proveedoresServices;

    @Autowired
    public ProveedoresController(ProveedoresServices proveedoresServices) {
        this.proveedoresServices = proveedoresServices;
    }

    @GetMapping("/proveedores")
    public String listProveedores(Model model) {
        List<ProveedoresDto> proveedores = proveedoresServices.findAllProveedores();
        model.addAttribute("proveedores", proveedores);
        return "proveedores-list";
    }

    @GetMapping("/proveedores/new")
    public String createProveedoresForm(Model model) {
        Proveedores proveedores = new Proveedores();
        model.addAttribute("proveedores", proveedores);
        return "proveedores-create";
    }

    @PostMapping("/proveedores/new")
    public String saveProveedores(@ModelAttribute("proveedores") Proveedores proveedores) {
        proveedoresServices.saveProveedores(proveedores);
        return "redirect:/proveedores";
    }
}
