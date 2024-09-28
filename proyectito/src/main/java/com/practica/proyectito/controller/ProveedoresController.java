package com.practica.proyectito.controller;

import com.practica.proyectito.dto.ProveedoresDto;
import com.practica.proyectito.service.ProveedoresServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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



}
