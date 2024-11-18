package com.example.saga.inventory.event;

import com.example.saga.common.TransactionStatus;
import com.example.saga.orchestrator.OrderEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class InventoryOrderEvent implements OrderEvent {
    UUID orderId;
    TransactionStatus status;
}