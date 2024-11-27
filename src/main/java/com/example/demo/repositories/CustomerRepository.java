package com.example.demo.repositories;

import com.example.demo.entities.Customer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {


      List<Customer> findAll();
      Customer getById(Long id);
      Customer findByUserName(String userName);


}


