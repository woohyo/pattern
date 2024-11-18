package com.example.saga.inventory.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Inventory {
    private UUID id;
    private UUID orderId;
}
