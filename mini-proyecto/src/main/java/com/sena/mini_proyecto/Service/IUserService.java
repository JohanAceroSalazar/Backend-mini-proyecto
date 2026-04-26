//Interface metodos que se deben de cumplir en la implement
package com.sena.mini_proyecto.Service;

import java.util.List;
import java.util.UUID;
import com.sena.mini_proyecto.Entity.User;
import com.sena.mini_proyecto.Dto.UserDto;

public interface IUserService {

    public List<User> findAll();
    public User findById(UUID id);
    public List<User> filterByName(String name);
    public String save(UserDto dto);
    String update(UUID id, UserDto userDto);
    public String delete(UUID id);
}