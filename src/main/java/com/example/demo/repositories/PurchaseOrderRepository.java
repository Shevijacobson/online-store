package com.example.demo.repositories;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Product;
import com.example.demo.entities.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder,Long> {

    List<PurchaseOrder> findAll();


    // שליפת הזמנות לפי תאריך
    List<PurchaseOrder> findByDate(String date);
    List<PurchaseOrder> findByDateBetween(String startDate, String endDate);
    List<PurchaseOrder> findByCustomerId(Long customerId);

    @Query("select po from PurchaseOrder po join po.orderList ol join Customer c on c.id = ?1")
    List<PurchaseOrder> findOrdersByCustomerId(Long customerId);

    @Query("select po from PurchaseOrder po where po.date between ?1 and ?2")
    List<PurchaseOrder> findOrdersBetweenDates(String startDate, String endDate);

    @Query("select po from PurchaseOrder po join po.orderList ol where ol.idProduct = ?1")
    List<PurchaseOrder> findOrdersByProductId(Long productId);

    @Query("select po from PurchaseOrder po where po.finalPrice > ?1")
    List<PurchaseOrder> findOrdersWithPriceGreaterThan(Double price);

    @Query("select po from PurchaseOrder po join po.orderList ol join Product p on ol.idProduct = p.id where p.category = ?1")
    List<PurchaseOrder> findOrdersByProductCategory(Product.Category category);
}
