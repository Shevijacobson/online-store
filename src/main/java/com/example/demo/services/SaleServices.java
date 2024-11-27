package com.example.demo.services;

import com.example.demo.entities.Sale;
import com.example.demo.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleServices {

    @Autowired
    private SaleRepository saleRepository;

    // יצירת מכירה חדשה
    public Sale createSale(Sale sale){
        return saleRepository.save(sale);
    }

    // שליפת כל המכירות
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    // שליפת מכירות לפי מזהה מוצר
    public List<Sale> getSalesByProductId(Long productId) {
        return saleRepository.findByIdProduct(productId);
    }

    // שליפת מכירות לפי טווח תאריכים
    public List<Sale> getSalesByDateRange(String startDate, String endDate) {
        return saleRepository.findByDateBetween(startDate, endDate);
    }

    // עדכון מכירה קיימת
    public Sale updateSale(Long saleId, Sale saleDetails) {
        Optional<Sale> saleOptional = saleRepository.findById(saleId);
        if (saleOptional.isPresent()) {
            Sale existingSale = saleOptional.get();
            existingSale.setIdProduct(saleDetails.getIdProduct());
            existingSale.setQuantity(saleDetails.getQuantity());
            existingSale.setReduction(saleDetails.getReduction());
            return saleRepository.save(existingSale);
        }
        return null;  // אם לא נמצא מכירה עם ה-ID
    }

    // מחיקת מכירה
    public void deleteSale(Long saleId) {
        saleRepository.deleteById(saleId);
    }

    // שליפת מכירות לפי כמות
    public List<Sale> getSalesByQuantity(int quantity) {
        return saleRepository.findByQuantityGreaterThanEqual(quantity);
    }
}

