package com.example.saga.orchestrator;

import com.example.saga.common.TransactionStatus;

import java.util.UUID;

public interface OrderEvent {
    UUID getOrderId();
    TransactionStatus getStatus();
}
