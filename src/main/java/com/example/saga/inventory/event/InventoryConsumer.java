package com.example.saga.inventory.event;

import com.example.saga.common.TransactionStatus;
import com.example.saga.inventory.InventoryService;
import com.example.saga.order.event.OrderCreateEvent;
import com.example.saga.payment.domain.PaymentException;
import com.example.saga.payment.event.PaymentOrderEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InventoryConsumer {
    private final InventoryService inventoryService;
    public void consume(InventoryOrderEvent event) {
        if (event.getStatus().equals(TransactionStatus.PROCESS)) {
            inventoryService.add(event.orderId);
        } else if (event.getStatus().equals(TransactionStatus.ROLLBACK)) {
            inventoryService.revert(event.orderId);
        }
    }
}
