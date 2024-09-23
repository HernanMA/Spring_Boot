package com.RestaurantManagement.restaurantManagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mesas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int numberTable;
    private boolean busy;

    public Mesas() {
    }

    public Mesas(long id, int numberTable, boolean busy) {
        this.id = id;
        this.numberTable = numberTable;
        this.busy = busy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumberTable() {
        return numberTable;
    }

    public void setNumberTable(int numberTable) {
        this.numberTable = numberTable;
    }

    public boolean getBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    @Override
    public String toString() {
        return "Mesas{" +
                "id=" + id +
                ", numberTable=" + numberTable +
                ", busy=" + busy +
                '}';
    }
}
