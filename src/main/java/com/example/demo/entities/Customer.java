package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.*;

@Entity
public class Customer {

    public enum Permission{
        ROLE_USER,
        ROLE_ADMIN,
    }
    @Id
    @GeneratedValue
    private  long id;
    private Permission permission;
private String userName;
private  String password;
private  String email;
private  String address;
@OneToMany
private List<PurchaseOrder> orderList = new ArrayList<>();


    public Customer() {
    }

    public Customer(String userName, String password, String email, String address,Permission permission) {
        this.permission=permission;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.address = address;
    }

    public List<PurchaseOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<PurchaseOrder> orderList) {
        this.orderList = orderList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
