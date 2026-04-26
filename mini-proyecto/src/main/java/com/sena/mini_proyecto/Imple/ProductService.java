package com.sena.mini_proyecto.Imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import com.sena.mini_proyecto.Entity.Product;
import com.sena.mini_proyecto.Dto.ProductDto;
import com.sena.mini_proyecto.Repository.ProductRepository;
import com.sena.mini_proyecto.Service.IProductService;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository repo;

    @Override
    public List<Product> findAll() {
        return repo.findAll();
    }

    @Override
    public Product findById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Product> filterByNameProduct(String name) {
        return repo.filterByNameProduct(name);
    }

    @Override
    public String save(ProductDto dto) {
        Product p = new Product();
        p.setName(dto.getName());
        p.setDescription(dto.getDescription());
        p.setPrice(dto.getPrice());

        repo.save(p);
        return "Product created";
    }

    @Override
    public String update(UUID id, ProductDto dto) {
        Product p = repo.findById(id).orElse(null);
        if (p == null) return "Product not found";

        p.setName(dto.getName());
        p.setDescription(dto.getDescription());
        p.setPrice(dto.getPrice());

        repo.save(p);
        return "Product updated";
    }

    @Override
    public String delete(UUID id) {
        repo.deleteById(id);
        return "Product deleted";
    }
}