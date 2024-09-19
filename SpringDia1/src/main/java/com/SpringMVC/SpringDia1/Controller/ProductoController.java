package com.SpringMVC.SpringDia1.Controller;

import com.SpringMVC.SpringDia1.Dto.ProductoDTO;
import com.SpringMVC.SpringDia1.Model.Producto;
import com.SpringMVC.SpringDia1.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductoController {
    private ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/productos")
    public String listProducts(Model model) {
        List<ProductoDTO> productos = productoService.findAllProductos();
        model.addAttribute("productos", productos);
        return "productos-list";
    }
}
