package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {


    public enum Category{

        Vegetables,
        Fruit,
        Sweets,
    }

    @Id
    @GeneratedValue
    private  long id;
    private  String name;

    private Category category;
    private  double price;

    private boolean onSale;

    public Product() {
    }

    public Product(String name, Category category, double price,boolean onSale) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.onSale = onSale;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public boolean isOnSale() {
        // לוגיקה לבדיקה אם המוצר במבצע, למשל אם הקטגוריה היא מתוקים או המחיר מתחת לסכום מסוים
        return this.category == Category.Sweets || this.price < 10.0;
    }
//    public boolean isOnSale() {
//        return onSale;
//    }
}
