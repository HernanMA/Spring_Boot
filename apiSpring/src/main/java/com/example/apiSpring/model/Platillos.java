package com.RestaurantManagement.restaurantManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Platillos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;
    private boolean enable;

    public Platillos() {
    }

    public Platillos(long id, double price, String name, boolean enable) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.enable = enable;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean getEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Override
    public String toString() {
        return "Platillos{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", enable=" + enable +
                '}';
    }
}
