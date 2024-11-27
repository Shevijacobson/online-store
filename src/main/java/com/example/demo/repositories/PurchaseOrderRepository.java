package com.example.demo.repositories;

import com.example.demo.entities.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder,Long> {

    List<PurchaseOrder> findAll();
    // שליפת הזמנות לפי מזהה לקוח
    List<PurchaseOrder> findByCustomerId(Long customerId);

    // שליפת הזמנות לפי תאריך
    List<PurchaseOrder> findByDate(String date);

}
