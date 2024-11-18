package com.example.saga.item.event;

import com.example.saga.common.TransactionStatus;
import com.example.saga.orchestrator.OrderEvent;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class OrderItemOrderEvent implements OrderEvent {
    private UUID id;
    private UUID orderId;
    private int cnt;
    private TransactionStatus status;
}
