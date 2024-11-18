package com.example.saga.payment.event;

import com.example.saga.common.TransactionStatus;
import com.example.saga.orchestrator.OrderEvent;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class PaymentOrderEvent implements OrderEvent {
    UUID orderId;
    int amount;
    TransactionStatus status;
}

