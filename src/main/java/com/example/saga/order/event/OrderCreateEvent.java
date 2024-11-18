package com.example.saga.order.event;

import com.example.saga.common.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
public class OrderCreateEvent implements com.example.saga.orchestrator.OrderEvent {
    UUID orderId;
    TransactionStatus status;
    UUID itemId;
    int itemCnt;
    int amount;
    public OrderCreateEvent(UUID orderId, TransactionStatus status) {
        this.orderId = orderId;
        this.status = status;
    }

    @Override
    public TransactionStatus getStatus() {
        return status;
    }
}
