package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


    @Entity
    public class PurchaseOrder {

        @Id
        @GeneratedValue
        private long id;
        @OneToMany
        private List<ItemOrder> orderList= new ArrayList<>();
        @ManyToOne
        private Customer customer;

        private double finalPrice;
        private String date;
        public PurchaseOrder(){}

        public PurchaseOrder(List<ItemOrder> orderList, double finalPrice,String date) {
            this.orderList = orderList;
            this.finalPrice = finalPrice;
        }

        public void setId(long id) {
            this.id = id;
        }
        public  void  setDate(String date){ this.date=date;}
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

        public  String  getDate(){return date;}

}
