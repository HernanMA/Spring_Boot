package com.practica.proyectito.controller;

import com.practica.proyectito.dto.MovimientosInventarioDto;
import com.practica.proyectito.service.Movimientos_InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MovimientoInventarioController {

    private final Movimientos_InventarioService movimientosInventarioService;

    @Autowired
    public MovimientoInventarioController(Movimientos_InventarioService movimientosInventarioService) {
        this.movimientosInventarioService = movimientosInventarioService;
    }

    @GetMapping("/movimientos")
    public String listMovimientos(Model model) {
        List<MovimientosInventarioDto> movimientosInventario = movimientosInventarioService.findAllMovimientosInventario();
        model.addAttribute("movimientos", movimientosInventario);
        return "movimientos-list";
    }
}
