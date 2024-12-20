package com.example.demo.services;

import com.example.demo.entities.Product;
import com.example.demo.entities.PurchaseOrder;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;
    @Autowired
    private ProductRepository productRepository;
    // שליפת כל הזמנות הרכישה
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderRepository.findAll();
    }

    // שליפת הזמנה לפי ID
    public Optional<PurchaseOrder> getPurchaseOrderById(Long id) {
        return purchaseOrderRepository.findById(id);
    }

    // שליפת הזמנות לפי מזהה לקוח
//    public List<PurchaseOrder> getPurchaseOrdersByCustomerId(Long customerId) {
//        return purchaseOrderRepository.findByCustomerId(customerId);
//    }

    // שליפת הזמנות לפי תאריך
    public List<PurchaseOrder> getPurchaseOrdersByDate(String date) {
        return purchaseOrderRepository.findByDate(date);
    }

    // הוספת הזמנה חדשה
    public PurchaseOrder addPurchaseOrder(PurchaseOrder purchaseOrder) {
        return purchaseOrderRepository.save(purchaseOrder);
    }

    // עדכון הזמנה
    public PurchaseOrder updatePurchaseOrder(Long id, PurchaseOrder purchaseOrder) {
        if (purchaseOrderRepository.existsById(id)) {
            purchaseOrder.setId(id); // עדכון ה-ID של ההזמנה
            return purchaseOrderRepository.save(purchaseOrder);
        }
        throw new RuntimeException("PurchaseOrder not found with id " + id);
    }
    public List<PurchaseOrder> getPurchaseOrdersByCustomerId(Long customerId) {
        return purchaseOrderRepository.findByCustomerId(customerId);
    }
    public List<PurchaseOrder> getPurchaseOrdersByDateRange(String startDate, String endDate) {
        return purchaseOrderRepository.findByDateBetween(startDate, endDate);
    }

    public double calculateFinalPrice(PurchaseOrder order) {
        return order.getOrderList().stream()
                .mapToDouble(item -> {
                    double price = item.getLastPrice();
                    boolean isOnSale = productRepository.findById(item.getIdProduct())
                            .map(Product::isOnSale)
                            .orElse(false);
                    return isOnSale ? price * 0.9 : price; // הנחה של 10% אם המוצר במבצע
                })
                .sum();
    }
    public List<PurchaseOrder> getOrdersByCustomerId(Long customerId) {
        return purchaseOrderRepository.findOrdersByCustomerId(customerId);
    }


}
