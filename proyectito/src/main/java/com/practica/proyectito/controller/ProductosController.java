package com.practica.proyectito.controller;

import com.practica.proyectito.dto.ProductosDto;
import com.practica.proyectito.models.Productos;
import com.practica.proyectito.service.ProductoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/productos/new")
    public String createProductoForm(Model model) {
        Productos productos = new Productos();
        model.addAttribute("productos", productos);
        return "productos-create";
    }

    @PostMapping("/productos/new")
    public String saveProductos(@ModelAttribute("productos") Productos productos) {
        productoServices.saveProductos(productos);
        return "redirect:/productos";
    }

    @GetMapping("/productos/{productosId}/edit")
    public String editProductosForm(@PathVariable("productosId") Long productosId, Model model) {
        ProductosDto productos = productoServices.findProductosById(productosId);
        model.addAttribute("productos", productos);
        return "productos-edit";
    }

    @PostMapping("/productos/{productosId}/edit")
    public String updateProducto(@PathVariable("productosId") Long productosId, @ModelAttribute("productos") ProductosDto productos) {
        productos.setId(productosId);
        productoServices.updateProducto(productos);
        return "redirect:/productos";
    }
}
