package com.practica.proyectito.service.impl;

import com.practica.proyectito.dto.MovimientosInventarioDto;
import com.practica.proyectito.models.Movimientos_Inventario;
import com.practica.proyectito.repository.Movimientos_InventarioRepository;
import com.practica.proyectito.service.Movimientos_InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class Movimientos_InventarioServiceImpl implements Movimientos_InventarioService {

    private Movimientos_InventarioRepository movimientosInventarioRepository;

    @Autowired
    public Movimientos_InventarioServiceImpl(Movimientos_InventarioRepository movimientosInventarioRepository) {
        this.movimientosInventarioRepository = movimientosInventarioRepository;
    }

    @Override
    public List<MovimientosInventarioDto> findAllMovimientosInventario() {
        List<Movimientos_Inventario> movimientosInventario = movimientosInventarioRepository.findAll();
        return movimientosInventario.stream().map((movimientosInventarios) -> mapToMovimientosInventarioDto(movimientosInventarios)).collect(Collectors.toList());
    }

    @Override
    public Movimientos_Inventario saveMovimientos(Movimientos_Inventario movimientosInventario) {
        return movimientosInventarioRepository.save(movimientosInventario);
    }

    private MovimientosInventarioDto mapToMovimientosInventarioDto(Movimientos_Inventario movimientosInventario) {
        MovimientosInventarioDto movimientosInventarioDto = MovimientosInventarioDto.builder()
                .id(movimientosInventario.getId())
                .producto_id(movimientosInventario.getProducto_id())
                .fecha(movimientosInventario.getFecha())
                .cantidad(movimientosInventario.getCantidad())
                .tipo_movimiento(movimientosInventario.getTipo_movimiento())
                .build();
        return movimientosInventarioDto;
    }
}
