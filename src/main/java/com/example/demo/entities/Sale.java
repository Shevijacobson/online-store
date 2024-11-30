package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Sale {
    @Id
    @GeneratedValue
    private  Long id;
    private  Long idProduct;
    private  int quantity;
    private  double reduction;
    private String date;
    private LocalDate expirationDate;

    public Sale() {
    }

    public Sale(Long idProduct, int quantity, double reduction) {
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.reduction = reduction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getReduction() {
        return reduction;
    }

    public void setReduction(double reduction) {
        this.reduction = reduction;
    }
}
