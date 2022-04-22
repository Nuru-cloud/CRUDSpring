package com.example.springprac.repository;

import com.example.springprac.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer > {

    Optional<Product> findProductByName(String name);

    Optional<Product> findProductById(int id);

    void deleteProductById(int id);
}
