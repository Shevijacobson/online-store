package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ItemOrder {


        @Id
        @GeneratedValue
        private Long id;
        private Long idProduct;
        private  int quantity;
        private  double lastPrice;

        public ItemOrder() {
        }

        public ItemOrder(Long idProduct, int quantity, double lastPrice) {
            this.idProduct = idProduct;
            this. quantity = quantity;
            this.lastPrice = lastPrice;
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
            quantity = quantity;
        }

        public double getLastPrice() {
            return lastPrice;
        }

        public void setLastPrice(double lastPrice) {
            this.lastPrice = lastPrice;
        }


}
