package com.sena.mini_proyecto.Controller;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sena.mini_proyecto.Entity.Product;
import com.sena.mini_proyecto.Dto.ProductDto;
import com.sena.mini_proyecto.Service.IProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService service;

    @GetMapping("")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(
            service.findAll(), HttpStatus.OK
        );
    }

    @PostMapping("")
    public ResponseEntity<Object> save(
        @RequestBody ProductDto dto) {

        service.save(dto);
        return new ResponseEntity<>(
            "Product created successfully", HttpStatus.OK
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findById(
        @PathVariable UUID id) {

        Product product = service.findById(id);
        return new ResponseEntity<>(
            product, HttpStatus.OK
        );
    }

    @GetMapping("filterbyname/{name}")
    public ResponseEntity<Object> filterByNameProduct(
        @PathVariable String name) {

        List<Product> products = service.filterByNameProduct(name);
        return new ResponseEntity<>(
            products, HttpStatus.OK
        );
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(
        @PathVariable UUID id,
        @RequestBody ProductDto dto) {

        String response = service.update(id, dto);
        return new ResponseEntity<>(
            response, HttpStatus.OK
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(
        @PathVariable UUID id) {

        service.delete(id);
        return new ResponseEntity<>(
            "Product deleted successfully", HttpStatus.OK
        );
    }
}