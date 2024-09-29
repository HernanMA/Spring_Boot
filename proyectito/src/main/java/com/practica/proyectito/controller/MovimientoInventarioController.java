package com.practica.proyectito.controller;

import com.practica.proyectito.dto.MovimientosInventarioDto;
import com.practica.proyectito.models.Categorias;
import com.practica.proyectito.models.Movimientos_Inventario;
import com.practica.proyectito.service.Movimientos_InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/movimientos/new")
    public String createMovimientosForm(Model model) {
        Movimientos_Inventario movimientosInventario = new Movimientos_Inventario();
        model.addAttribute("movimientosInventario", movimientosInventario);
        return "movimientos-create";
    }

    @PostMapping("/movimientos/new")
    public String saveMovimientos(@ModelAttribute("movimientosInventario") Movimientos_Inventario movimientosInventario) {
        movimientosInventarioService.saveMovimientos(movimientosInventario);
        return "redirect:/movimientos";
    }

    @GetMapping("/movimientos/{movimientosId}/edit")
    public String editMovimientosForm(@PathVariable("movimientosId") Long movimientosId, Model model) {
        MovimientosInventarioDto movimientosInventario = movimientosInventarioService.findMovimientosByid(movimientosId);
        model.addAttribute("movimientosInventario", movimientosInventario);
        return "movimientos-edit";
    }

    @PostMapping("/movimientos/{movimientosId}/edit")
    public String updateMovimientos(@PathVariable("movimientosId") Long movimientosId, @ModelAttribute("movimientosInventario") MovimientosInventarioDto movimientosInventario) {
        movimientosInventario.setId(movimientosId);
        movimientosInventarioService.updateMovimientos(movimientosInventario);
        return "redirect:/movimientos";
    }
}
