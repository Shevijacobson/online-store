package com.example.demo.controllers;

        import com.example.demo.entities.Product;
        import com.example.demo.services.ProductService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;
        import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // שליפת כל המוצרים
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // שליפת מוצר לפי ID
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // הוספת מוצר חדש
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    // עדכון מוצר
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    // שליפת מוצרים לפי קטגוריה
//    @GetMapping("/category/{category}")
//    public List<Product> getProductsByCategory(@PathVariable String category) {
//        return productService.getProductsByCategory(category);
//    }
}
