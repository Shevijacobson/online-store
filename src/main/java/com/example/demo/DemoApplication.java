package com.example.demo;

import com.example.demo.entities.Sale;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Transactional
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

@PersistenceContext
private EntityManager entityManager;

	@Override
	public void run(String... args) throws Exception {
		Sale sale1=new Sale(2L,3,2.5);
		entityManager.persist(sale1);

	}
}
