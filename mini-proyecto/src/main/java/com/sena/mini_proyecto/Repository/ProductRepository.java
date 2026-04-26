package com.sena.mini_proyecto.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.sena.mini_proyecto.Entity.Product;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query(""
			+ "SELECT "
			+ "p "
			+ "FROM "
			+ "products p "
			+ "WHERE "
			+ "p.total like %?1%"
			)
	public List<Product>filterByNameProduct(String name);
}