package com.sena.mini_proyecto.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sena.mini_proyecto.entity.Order;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

    @Query(""
			+ "SELECT "
			+ "o "
			+ "FROM "
			+ "Order o "
			+ "WHERE "
			+ "o.total = ?1"
			)
	public List<Order>filterByTotal(double total);
}