package com.SpringMVC.SpringDia1.Repository;

import com.SpringMVC.SpringDia1.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Optional<Producto> FindByName(String url);
}
