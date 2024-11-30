package com.example.demo.services;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // שליפת כל המוצרים
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // שליפת מוצר לפי ID
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    // הוספת מוצר חדש
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // עדכון מוצר
    public Product updateProduct(Long id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id); // שים לב לעדכן את ה-ID של המוצר
            return productRepository.save(product);
        }
        throw new RuntimeException("Product not found with id " + id);
    }

    // שליפת מוצרים לפי קטגוריה
//    public List<Product> getProductsByCategory(String category) {
//        try {
////            return productRepository.findByCategory(Product.Category.valueOf(category));
//            return productRepository.findByCategory(category);
//
//        }
//        catch (IllegalArgumentException e) {
//            throw new RuntimeException("Invalid category: " + category);
//        }
//    }
}
