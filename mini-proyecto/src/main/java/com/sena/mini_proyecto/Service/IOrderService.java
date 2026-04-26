package com.sena.mini_proyecto.Service;

import java.util.List;
import java.util.UUID;
import com.sena.mini_proyecto.Entity.Order;
import com.sena.mini_proyecto.Dto.OrderDto;

public interface IOrderService {

    public List<Order> findAll();
    public Order findById(UUID id);
    public List<Order>filterByTotal(double total);
    public String save(OrderDto dto);
    String update(UUID id, OrderDto dto);
    public String delete(UUID id);
}