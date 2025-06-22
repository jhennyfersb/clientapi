package com.xp.clientapi.service;

import com.xp.clientapi.entity.Product;

import java.util.List;

public interface ProductService {

    Product create(Product product);

    List<Product> findAll();

    long count();

    Product findById(Long id);

    List<Product> findByName(String name);

    Product update(Long id, Product product);

    void delete(Long id);
}