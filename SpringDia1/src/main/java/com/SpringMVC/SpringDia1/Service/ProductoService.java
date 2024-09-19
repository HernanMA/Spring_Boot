package com.SpringMVC.SpringDia1.Service;

import com.SpringMVC.SpringDia1.Dto.ProductoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductoService {
    List<ProductoDTO> findAllProductos();
}
