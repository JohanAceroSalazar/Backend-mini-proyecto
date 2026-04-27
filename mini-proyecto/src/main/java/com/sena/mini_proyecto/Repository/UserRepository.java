//Acceso a la base de datos
package com.sena.mini_proyecto.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sena.mini_proyecto.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Query(""
			+ "SELECT "
			+ "u "
			+ "FROM "
			+ "User u "
			+ "WHERE "
			+ "u.name like %?1%"
			)
	public List<User>filterByName(String name);
}