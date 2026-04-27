package com.sena.mini_proyecto.controller;

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

import com.sena.mini_proyecto.dto.UserDto;
import com.sena.mini_proyecto.entity.User;
import com.sena.mini_proyecto.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService service;

    // Obtener todos
    @GetMapping("")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(
            service.findAll(), HttpStatus.OK
        );
    }

    // Crear usuario
    @PostMapping("")
    public ResponseEntity<Object> save(
        @RequestBody UserDto dto) {

        service.save(dto);
        return new ResponseEntity<>(
            "User created successfully", HttpStatus.OK
        );
    }

    // Obtener por ID
    @GetMapping("{id}")
    public ResponseEntity<Object> findById(
        @PathVariable UUID id) {

        User user = service.findById(id);
        return new ResponseEntity<>(
            user, HttpStatus.OK
        );
    }

    // Filtrar por nombre
    @GetMapping("filterbyname/{name}")
    public ResponseEntity<Object> filterByName(
        @PathVariable String name) {

        List<User> users = service.filterByName(name);
        return new ResponseEntity<>(
            users, HttpStatus.OK
        );
    }

    // Actualizar usuario
    @PutMapping("{id}")
    public ResponseEntity<Object> update(
        @PathVariable UUID id,
        @RequestBody UserDto dto) {

        String response = service.update(id, dto);
        return new ResponseEntity<>(
            response, HttpStatus.OK
        );
    }

    // Eliminar usuario
    @DeleteMapping("{id}")
    public ResponseEntity<Object> delete(
        @PathVariable UUID id) {

        service.delete(id);
        return new ResponseEntity<>(
            "User deleted successfully", HttpStatus.OK
        );
    }
}