package com.example.outbox.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Getter
@AllArgsConstructor
public class OrderEntity {
    private UUID id;
    private OrderStatus status;
    private OrderStatus previousStatus;

    public static OrderEntity create() {
        return new OrderEntity(
                UUID.randomUUID(),
                OrderStatus.PENDING,
                null
        );
    }

    public void cancel() {
        this.previousStatus = this.status;
        this.status = OrderStatus.CANCEL;
    }

    public void delivery() {
        this.previousStatus = this.status;
        this.status = OrderStatus.DELIVERY;
    }

    public void shipped() {
        this.previousStatus = this.status;
        this.status = OrderStatus.SHIPPED;
    }

    public void rollback() {
        this.status = this.previousStatus;
    }
}
