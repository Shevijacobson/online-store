package com.example.demo.controllers;

import com.example.demo.entities.Sale;
import com.example.demo.services.SaleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {

    @Autowired
    private SaleServices saleServices;

    // יצירת מכירה חדשה
    @PostMapping("/addSale")
    public Sale createSale(@RequestBody Sale sale) {
        return saleServices.createSale(sale);
    }

    // שליפת כל המכירות
    @GetMapping("/getAllSales")
    public List<Sale> getAllSales() {
        return saleServices.getAllSales();
    }

    // שליפת מכירות לפי מזהה מוצר
    @GetMapping("/getSalesByProduct/{idProduct}")
    public List<Sale> getSalesByProductId(@PathVariable Long idProduct) {
        return saleServices.getSalesByProductId(idProduct);
    }

    // שליפת מכירות לפי טווח תאריכים
    @GetMapping("/getSalesByDateRange")
    public List<Sale> getSalesByDateRange(@RequestParam String startDate, @RequestParam String endDate) {
        return saleServices.getSalesByDateRange(startDate, endDate);
    }

    // עדכון מכירה
    @PutMapping("/updateSale/{saleId}")
    public Sale updateSale(@PathVariable Long saleId, @RequestBody Sale saleDetails) {
        return saleServices.updateSale(saleId, saleDetails);
    }

    // מחיקת מכירה
    @DeleteMapping("/deleteSale/{saleId}")
    public ResponseEntity<?> deleteSale(@PathVariable Long saleId) {
        saleServices.deleteSale(saleId);
        return ResponseEntity.ok().build();
    }

    // שליפת מכירות לפי כמות
    @GetMapping("/getSalesByQuantity/{quantity}")
    public List<Sale> getSalesByQuantity(@PathVariable int quantity) {
        return saleServices.getSalesByQuantity(quantity);
    }
}
