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
    public Movimientos_Inventario saveMovimientos(MovimientosInventarioDto movimientosInventarioDto) {
        Movimientos_Inventario movimientosInventario = mapToMovimientosInventario(movimientosInventarioDto);
        return movimientosInventarioRepository.save(movimientosInventario);
    }

    @Override
    public MovimientosInventarioDto findMovimientosByid(Long movimientosId) {
        Movimientos_Inventario movimientos = movimientosInventarioRepository.findById(movimientosId).get();
        return mapToMovimientosInventarioDto(movimientos);
    }

    @Override
    public void updateMovimientos(MovimientosInventarioDto movimientosInventarioDto) {
        Movimientos_Inventario movimientos = mapToMovimientosInventario(movimientosInventarioDto);
        movimientosInventarioRepository.save(movimientos);
    }

    private Movimientos_Inventario mapToMovimientosInventario(MovimientosInventarioDto movimientos) {
        Movimientos_Inventario movimientosInventarioDto = Movimientos_Inventario.builder()
                .id(movimientos.getId())
                .producto_id(movimientos.getProducto_id())
                .fecha(movimientos.getFecha())
                .cantidad(movimientos.getCantidad())
                .tipo_movimiento(movimientos.getTipo_movimiento())
                .build();
        return  movimientosInventarioDto;
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
