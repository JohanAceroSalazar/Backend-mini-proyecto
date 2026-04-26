package com.sena.mini_proyecto.Dto;

import lombok.Data;
import java.util.UUID;

@Data
public class OrderDto {
    private UUID userId;
    private UUID productId;
    private Double total;
}