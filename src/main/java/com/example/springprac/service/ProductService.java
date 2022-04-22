package com.example.springprac.service;

import com.example.springprac.entity.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> saveProducts(List<Product> products);

    Product getProductByID(int id);

    Product getProductByName(String name);

    String deleteProduct(int id);

    Product updateProduct(Product product, int id);

    List<Product> getProducts();
}
