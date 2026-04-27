//Logica del negocio: validaciones y lo que decide que hacer
package com.sena.mini_proyecto.imple;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

import com.sena.mini_proyecto.dto.UserDto;
import com.sena.mini_proyecto.entity.User;
import com.sena.mini_proyecto.repository.UserRepository;
import com.sena.mini_proyecto.service.IUserService;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repo;

    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    @Override
    public User findById(UUID id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<User> filterByName(String name){
        return repo.filterByName(name);
    }

    @Override
    public String save(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setEmail(dto.getEmail());

        repo.save(user);
        return "User created";
    }

    @Override
    public String update(UUID id, UserDto dto) {
        User user = repo.findById(id).orElse(null);
        if (user == null) return "User not found";

        user.setName(dto.getName());
        user.setAge(dto.getAge());
        user.setEmail(dto.getEmail());

        repo.save(user);
        return "User updated";
    }

    @Override
    public String delete(UUID id) {
        repo.deleteById(id);
        return "User deleted";
    }
}