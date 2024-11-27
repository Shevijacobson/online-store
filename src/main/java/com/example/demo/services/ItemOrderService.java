

package com.example.demo.services;

import com.example.demo.entities.ItemOrder;
import com.example.demo.repositories.ItemOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemOrderService {

    @Autowired
    private ItemOrderRepository itemOrderRepository;

    // שליפת כל ההזמנות
    public List<ItemOrder> getAllItemOrders() {
        return itemOrderRepository.findAll();
    }

    // שליפת הזמנה לפי ID
    public Optional<ItemOrder> getItemOrderById(Long id) {
        return itemOrderRepository.findById(id);
    }

    // הוספת הזמנה חדשה
    public ItemOrder addItemOrder(ItemOrder itemOrder) {
        return itemOrderRepository.save(itemOrder);
    }

    // עדכון הזמנה
    public ItemOrder updateItemOrder(Long id, ItemOrder itemOrder) {
        if (itemOrderRepository.existsById(id)) {
            itemOrder.setId(id); // עדכון ה-ID של ההזמנה
            return itemOrderRepository.save(itemOrder);
        }
        throw new RuntimeException("ItemOrder not found with id " + id);
    }
}

