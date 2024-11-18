package com.example.saga.item.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private UUID id;
    private int price;
    private int stockQuantity;

    public void decrement(int sq) {
        if (stockQuantity < sq) {
            throw new ItemException("재고 부족");
        }
        this.stockQuantity -= sq;
    }

    public void increment(int sq) {
        this.stockQuantity += sq;
    }
}
