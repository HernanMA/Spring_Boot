package com.practica.proyectito.service;

import com.practica.proyectito.dto.MovimientosInventarioDto;
import com.practica.proyectito.models.Movimientos_Inventario;

import java.util.List;

public interface Movimientos_InventarioService {
    List<MovimientosInventarioDto> findAllMovimientosInventario();
    Movimientos_Inventario saveMovimientos(MovimientosInventarioDto movimientosInventarioDto);

    MovimientosInventarioDto findMovimientosByid(Long movimientosId);

    void updateMovimientos(MovimientosInventarioDto movimientos);

    void delete(Long movimientosId);
}
