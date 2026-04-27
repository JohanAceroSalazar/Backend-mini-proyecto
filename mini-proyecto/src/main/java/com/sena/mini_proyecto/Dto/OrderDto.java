package com.sena.mini_proyecto.dto;

import lombok.Data;
import java.util.UUID;

@Data
public class OrderDto {
    private UUID userId;
    private UUID productId;
    private Double total;
}