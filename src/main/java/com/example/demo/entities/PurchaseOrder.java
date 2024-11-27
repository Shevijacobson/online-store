package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;


    @Entity
    public class PurchaseOrder {

        @Id
        @GeneratedValue
        private long id;
        @OneToMany
        private List<ItemOrder> orderList= new ArrayList<>();
        private double finalPrice;

        public PurchaseOrder(){}

        public PurchaseOrder(List<ItemOrder> orderList, double finalPrice) {
            this.orderList = orderList;
            this.finalPrice = finalPrice;
        }

        public void setId(long id) {
            this.id = id;
        }

        public void setOrderList(List<ItemOrder> orderList) {
            this.orderList = orderList;
        }

        public void setFinalPrice(double finalPrice) {
            this.finalPrice = finalPrice;
        }

        public long getId() {
            return id;
        }

        public List<ItemOrder> getOrderList() {
            return orderList;
        }

        public double getFinalPrice() {
            return finalPrice;
        }



}
