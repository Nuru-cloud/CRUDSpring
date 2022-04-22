package com.example.springprac.controller;

import com.example.springprac.entity.Product;
import com.example.springprac.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return productServiceImpl.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return productServiceImpl.saveProducts(products);
    }

    @GetMapping
    public List<Product> findAllProduct() {
        return productServiceImpl.getProducts();
    }

    @GetMapping("/byId/{productId}")
    public Product findProductById(@PathVariable(value = "productId") final int id) {
        return productServiceImpl.getProductByID(id);
    }

    @GetMapping("byName/{name}")
    public Product findProductByName(@PathVariable String name) {
        return productServiceImpl.getProductByName(name);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(
            @RequestBody Product product,
            @PathVariable(value = "id") final int id
            ) {
        return productServiceImpl.updateProduct(product, id);
    }

    @DeleteMapping
    public String deleteProduct(@RequestParam(value = "productId") final int id) {
        return productServiceImpl.deleteProduct(id);
    }

}
