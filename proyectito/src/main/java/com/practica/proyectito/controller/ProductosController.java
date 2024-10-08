package com.practica.proyectito.controller;

import com.practica.proyectito.dto.MovimientosInventarioDto;
import com.practica.proyectito.dto.ProductosDto;
import com.practica.proyectito.dto.ProveedoresDto;
import com.practica.proyectito.models.Productos;
import com.practica.proyectito.service.ProductoServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductosController {

    private final ProductoServices productoServices;

    @Autowired
    public ProductosController(ProductoServices productoServices) {
        this.productoServices = productoServices;
    }

    @GetMapping("/productos")
    public String listProductos(Model model) {
        List<ProductosDto> productos = productoServices.findAllProductos();
        model.addAttribute("productos", productos);
        return "productos-list";
    }

    @GetMapping("/productos/{productosId}")
    public String productosDetail(@PathVariable("productosId") Long productosId, Model model) {
        ProductosDto productosDto = productoServices.findProductosById(productosId);
        model.addAttribute("producto", productosDto);
        return "productos-detail";
    }

    @GetMapping("/productos/new")
    public String createProductoForm(Model model) {
        Productos productos = new Productos();
        model.addAttribute("productos", productos);
        return "productos-create";
    }

    @GetMapping("/productos/{productosId}/delete")
    public String deleteProductos(@PathVariable("productosId") Long productosId) {
        productoServices.delete(productosId);
        return "redirect:/productos";
    }

    @PostMapping("/productos/new")
    public String saveProductos(@Valid @ModelAttribute("productos") ProductosDto productosDto,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("productos", productosDto);
            return "productos-create";
        }
        productoServices.saveProductos(productosDto);
        return "redirect:/productos";
    }

    @GetMapping("/productos/{productosId}/edit")
    public String editProductosForm(@PathVariable("productosId") Long productosId, Model model) {
        ProductosDto productos = productoServices.findProductosById(productosId);
        model.addAttribute("productos", productos);
        return "productos-edit";
    }

    @PostMapping("/productos/{productosId}/edit")
    public String updateProducto(@PathVariable("productosId") Long productosId,
                                 @Valid @ModelAttribute("productos") ProductosDto productos,
                                 BindingResult result) {
        if (result.hasErrors()) {
            return "productos-edit";
        }
        productos.setId(productosId);
        productoServices.updateProducto(productos);
        return "redirect:/productos";
    }
}
