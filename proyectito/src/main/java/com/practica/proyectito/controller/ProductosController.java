package com.practica.proyectito.controller;

import com.practica.proyectito.dto.ProductosDto;
import com.practica.proyectito.service.ProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductosController {

    private final ProductoServices productoServices;

    @Autowired
    public ProductosController(ProductoServices productoServices) {
        this.productoServices = productoServices;
    }

    @GetMapping("productos")
    public String listProductos(Model model) {
        List<ProductosDto> productos = productoServices.findAllProductos();
        model.addAttribute("productos", productos);
        return "productos-list";
    }
}
