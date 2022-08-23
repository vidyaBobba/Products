package com.product.service;

import com.product.entity.Product;
import com.product.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<Product> findallProducts() {
        return (List<Product>) repository.findAll();
    }

    public Product findProductById(int id) {
        Optional<Product> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        return new Product();
    }

    public Product addProduct(Product product) {
        return repository.save(product);
    }

    public Product updateProduct(Product product) {
        Optional<Product> result = repository.findById(product.getId());
        Product existing = result.get();
        existing.setSize(product.getSize());
        existing.setBrand(product.getBrand());
        existing.setColour(product.getColour());
        existing.setType(product.getType());
        return repository.save(existing);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
