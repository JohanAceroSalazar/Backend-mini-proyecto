//Data Transfer Object: Recibe datos y los envia entre procesos
package com.sena.mini_proyecto.Dto;

import lombok.Data;

@Data
public class UserDto {
    private String name;
    private Integer age;
    private String email;
}