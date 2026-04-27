package com.sena.mini_proyecto.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

import com.sena.mini_proyecto.dto.OrderDto;
import com.sena.mini_proyecto.entity.Order;
import com.sena.mini_proyecto.entity.Product;
import com.sena.mini_proyecto.entity.User;
import com.sena.mini_proyecto.repository.OrderRepository;
import com.sena.mini_proyecto.repository.ProductRepository;
import com.sena.mini_proyecto.repository.UserRepository;
import com.sena.mini_proyecto.service.IOrderService;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository repo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ProductRepository productRepo;

    @Override
    public List<Order> findAll() {
        return repo.findAll();
    }

    @Override
    public Order findById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Order>filterByTotal(double total){
        return repo.filterByTotal(total);
    }

    @Override
    public String save(OrderDto dto) {
        User user = userRepo.findById(dto.getUserId()).orElse(null);
        Product product = productRepo.findById(dto.getProductId()).orElse(null);

        if (user == null || product == null) {
            return "User or Product not found";
        }

        Order o = new Order();
        o.setUser(user);
        o.setProduct(product);
        o.setTotal(dto.getTotal());

        repo.save(o);
        return "Order created";
    }

    @Override
    public String update(UUID id, OrderDto dto) {
        Order o = repo.findById(id).orElse(null);
        if (o == null) return "Order not found";

        User user = userRepo.findById(dto.getUserId()).orElse(null);
        Product product = productRepo.findById(dto.getProductId()).orElse(null);

        o.setUser(user);
        o.setProduct(product);
        o.setTotal(dto.getTotal());

        repo.save(o);
        return "Order updated";
    }

    @Override
    public String delete(UUID id) {
        repo.deleteById(id);
        return "Order deleted";
    }
}