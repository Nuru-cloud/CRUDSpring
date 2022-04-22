package com.example.springprac.controller;

import com.example.springprac.entity.Product;
import com.example.springprac.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private ProductServiceImpl productServiceImplBean;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImplBean = productServiceImpl;
    }

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product product) {
        return productServiceImplBean.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return productServiceImplBean.saveProducts(products);
    }

    @GetMapping
    public List<Product> findAllProduct() {
        return productServiceImplBean.getProducts();
    }

    @GetMapping("/byId/{productId}")
    public Product findProductById(@PathVariable(value = "productId") final int id) {
        return productServiceImplBean.getProductByID(id);
    }

    @GetMapping("byName/{name}")
    public Product findProductByName(@PathVariable String name) {
        return productServiceImplBean.getProductByName(name);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(
            @RequestBody Product product,
            @PathVariable(value = "id") final int id
            ) {
        return productServiceImplBean.updateProduct(product, id);
    }

    @DeleteMapping
    public String deleteProduct(@RequestParam(value = "productId") final int id) {
        return productServiceImplBean.deleteProduct(id);
    }

}
