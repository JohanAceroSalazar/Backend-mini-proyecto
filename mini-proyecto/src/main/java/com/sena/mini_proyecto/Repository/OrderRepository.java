package com.sena.mini_proyecto.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sena.mini_proyecto.Entity.Order;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

    @Query(""
			+ "SELECT "
			+ "o "
			+ "FROM "
			+ "orders o "
			+ "WHERE "
			+ "o.name like %?1%"
			)
	public List<Order>filterByTotal(double total);
}