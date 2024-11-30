package com.example.demo.controllers;

import com.example.demo.entities.PurchaseOrder;
import com.example.demo.services.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchase-orders")
public class PurchaseOrderController {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    // שליפת כל הזמנות הרכישה
    @GetMapping
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderService.getAllPurchaseOrders();
    }

    // שליפת הזמנה לפי ID
    @GetMapping("/{id}")
    public Optional<PurchaseOrder> getPurchaseOrderById(@PathVariable Long id) {
        return purchaseOrderService.getPurchaseOrderById(id);
    }

    // שליפת הזמנות לפי מזהה לקוח
//    @GetMapping("/customer/{customerId}")
//    public List<PurchaseOrder> getPurchaseOrdersByCustomerId(@PathVariable Long customerId) {
//        return purchaseOrderService.getPurchaseOrdersByCustomerId(customerId);
//    }

    // שליפת הזמנות לפי תאריך
    @GetMapping("/date/{date}")
    public List<PurchaseOrder> getPurchaseOrdersByDate(@PathVariable String date) {
        return purchaseOrderService.getPurchaseOrdersByDate(date);
    }

    // הוספת הזמנה חדשה
    @PostMapping
    public PurchaseOrder addPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
        return purchaseOrderService.addPurchaseOrder(purchaseOrder);
    }

    // עדכון הזמנה
    @PutMapping("/{id}")
    public PurchaseOrder updatePurchaseOrder(@PathVariable Long id, @RequestBody PurchaseOrder purchaseOrder) {
        return purchaseOrderService.updatePurchaseOrder(id, purchaseOrder);
    }

    @GetMapping("/customer/{customerId}")
    public List<PurchaseOrder> getOrdersByCustomerId(@PathVariable Long customerId) {
        return purchaseOrderService.getPurchaseOrdersByCustomerId(customerId);
    }
    @GetMapping("/date-range")
    public List<PurchaseOrder> getOrdersByDateRange(@RequestParam String startDate, @RequestParam String endDate) {
        return purchaseOrderService.getPurchaseOrdersByDateRange(startDate, endDate);
    }

    @GetMapping("/{id}/calculate-final-price")
    public double calculateFinalPrice(@PathVariable Long id) {
        return purchaseOrderService.getPurchaseOrderById(id)
                .map(purchaseOrderService::calculateFinalPrice)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }



}
