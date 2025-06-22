package com.xp.clientapi.service;

import com.xp.clientapi.entity.Product;
import com.xp.clientapi.exception.ResourceNotFoundException;
import com.xp.clientapi.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public Product create(Product product) {
        return repo.save(product);
    }

    @Override
    public List<Product> findAll() {
        return repo.findAll();
    }

    @Override
    public long count() {
        return repo.count();
    }

    @Override
    public Product findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found: " + id));
    }

    @Override
    public List<Product> findByName(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Product update(Long id, Product product) {
        Product existing = findById(id);
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        repo.delete(findById(id));
    }
}


