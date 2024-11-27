package com.example.demo.repositories;

import com.example.demo.entities.ItemOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemOrderRepository extends JpaRepository<ItemOrder,Long> {

    List<ItemOrder> findAll();

}
