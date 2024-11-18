package com.example.saga.order.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Order {
    private UUID id;
    private UUID itemId;
    private int itemCnt;
    private OrderStatus status;
}
