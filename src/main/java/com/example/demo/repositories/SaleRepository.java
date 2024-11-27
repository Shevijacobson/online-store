package com.example.demo.repositories;

import com.example.demo.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    List<Sale> findAll();

    // שליפת מכירות לפי מזהה מוצר
    List<Sale> findByIdProduct(Long idProduct);

    // שליפת מכירות לפי טווח תאריכים
    List<Sale> findByDateBetween(String startDate, String endDate);

    // שליפת מכירות לפי כמות
    List<Sale> findByQuantityGreaterThanEqual(int quantity);
}
