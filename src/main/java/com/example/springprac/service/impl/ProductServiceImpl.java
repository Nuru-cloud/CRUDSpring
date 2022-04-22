package com.example.springprac.service.impl;

import com.example.springprac.entity.Product;
import com.example.springprac.repository.ProductRepo;
import com.example.springprac.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> saveProducts(List<Product> products) {
        return productRepo.saveAll(products);
    }

    @Override
    public Product getProductByID(int id) {
        Optional<Product> optionalProduct = productRepo.findProductById(id);
        if (optionalProduct.isPresent()){
            return optionalProduct.get();
        }

        return new Product();
    }

    @Override
    public Product getProductByName(String name) {
        Optional<Product> optionalProduct = productRepo.findProductByName(name);

        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        return new Product();
    }

    @Override
    public String deleteProduct(int id) {
        Optional<Product> optionalProduct = productRepo.findProductById(id);

        if (optionalProduct.isPresent()){
            productRepo.deleteById(id);
            return "product removed!" + id;
        }

        return "Product not Found";
    }

    @Override
    public Product updateProduct(Product product, int id) {
        Optional<Product> optionalProduct = productRepo.findProductById(id);

        if (optionalProduct.isPresent()){
            return productRepo.save(
                    Product.builder()
                            .id(optionalProduct.get().getId())
                            .name(product.getName())
                            .quantity(product.getQuantity())
                            .price(product.getPrice())
                            .payment(product.getPayment())
                            .type(product.getType())
                            .build()
            );
        }
        return new Product();
    }

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }
}
