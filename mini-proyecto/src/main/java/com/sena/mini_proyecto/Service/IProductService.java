package com.sena.mini_proyecto.service;

import java.util.List;
import java.util.UUID;

import com.sena.mini_proyecto.dto.ProductDto;
import com.sena.mini_proyecto.entity.Product;

public interface IProductService {

    public List<Product> findAll();
    public Product findById(UUID id);
    public List<Product>filterByNameProduct(String name);
    public String save(ProductDto dto);
    String update(UUID id, ProductDto productDto);
    public String delete(UUID id);
}
