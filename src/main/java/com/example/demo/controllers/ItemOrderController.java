package com.example.demo.controllers;

import com.example.demo.entities.ItemOrder;
import com.example.demo.services.ItemOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item-orders")
public class ItemOrderController {

    @Autowired
    private ItemOrderService itemOrderService;

    // שליפת כל ההזמנות
    @GetMapping
    public List<ItemOrder> getAllItemOrders() {
        return itemOrderService.getAllItemOrders();
    }

    // שליפת הזמנה לפי ID
    @GetMapping("/{id}")
    public Optional<ItemOrder> getItemOrderById(@PathVariable Long id) {
        return itemOrderService.getItemOrderById(id);
    }

    // הוספת הזמנה חדשה
    @PostMapping
    public ItemOrder addItemOrder(@RequestBody ItemOrder itemOrder) {
        return itemOrderService.addItemOrder(itemOrder);
    }

    // עדכון הזמנה
    @PutMapping("/{id}")
    public ItemOrder updateItemOrder(@PathVariable Long id, @RequestBody ItemOrder itemOrder) {
        return itemOrderService.updateItemOrder(id, itemOrder);
    }
}
