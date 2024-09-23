package com.RestaurantManagement.restaurantManagement.repository;

import com.RestaurantManagement.restaurantManagement.model.Mesas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesasRepository extends  JpaRepository<Mesas, Long>{
}
