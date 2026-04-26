package com.sena.mini_proyecto.Service;

import java.util.List;
import java.util.UUID;
import com.sena.mini_proyecto.Entity.Product;
import com.sena.mini_proyecto.Dto.ProductDto;

public interface IProductService {

    public List<Product> findAll();
    public Product findById(UUID id);
    public List<Product>filterByNameProduct(String name);
    public String save(ProductDto dto);
    String update(UUID id, ProductDto productDto);
    public String delete(UUID id);
}
