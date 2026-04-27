package com.sena.mini_proyecto.Controller;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.sena.mini_proyecto.Entity.Order;
import com.sena.mini_proyecto.Dto.OrderDto;
import com.sena.mini_proyecto.Service.IOrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrderService service;

    @GetMapping("")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(
            service.findAll(), HttpStatus.OK
        );
    }

    @PostMapping("")
    public ResponseEntity<Object> save(
        @RequestBody OrderDto dto) {

        String response = service.save(dto);
        return new ResponseEntity<>(
            response, HttpStatus.OK
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> findById(
        @PathVariable UUID id) {

        Order order = service.findById(id);
        return new ResponseEntity<>(
            order, HttpStatus.OK
        );
    }

    @GetMapping("filterbytotal/{total}")
    public ResponseEntity<Object> filterByTotal(
        @PathVariable double total) {

        List<Order> orders = service.filterByTotal(total);
        return new ResponseEntity<>(
            orders, HttpStatus.OK
        );
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(
        @PathVariable UUID id,
        @RequestBody OrderDto dto) {

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
            "Order deleted successfully", HttpStatus.OK
        );
    }
}