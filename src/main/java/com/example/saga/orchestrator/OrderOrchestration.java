package com.example.saga.orchestrator;

import com.example.saga.common.TransactionStatus;
import com.example.saga.inventory.event.InventoryOrderEvent;
import com.example.saga.item.ItemService;
import com.example.saga.item.event.OrderItemOrderEvent;
import com.example.saga.order.OrderService;
import com.example.saga.order.domain.Order;
import com.example.saga.order.event.OrderCreateEvent;
import com.example.saga.payment.event.PaymentOrderEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OrderOrchestration {
    private final MessageProducer producer;

    @EventListener
    public void handleOrderEvent(OrderEvent orderEvent) {
        if (orderEvent.getStatus().equals(TransactionStatus.ROLLBACK)) {
            compensate(orderEvent);
        } else if (orderEvent instanceof OrderCreateEvent) {
            if (orderEvent.getStatus().equals(TransactionStatus.ROLLBACK)) {
                producer.send("order", orderEvent);
            } else if (orderEvent.getStatus().equals(TransactionStatus.PROCESS)) {
                OrderCreateEvent event = (OrderCreateEvent) orderEvent;
                producer.send("item", new OrderItemOrderEvent(event.getItemId(), event.getOrderId(), event.getItemCnt(), event.getStatus()));
                producer.send("inventory", new InventoryOrderEvent(event.getOrderId(), event.getStatus()));
            }
        } else if (orderEvent instanceof PaymentOrderEvent) {
            producer.send("payment", orderEvent);
        } else if (orderEvent instanceof InventoryOrderEvent) {
            producer.send("inventory", orderEvent);
        } else if (orderEvent instanceof OrderItemOrderEvent) {
            producer.send("item", orderEvent);
        } else {
            System.out.println("type casting error");
        }
    }

    private void compensate(OrderEvent event) {
        producer.send("order", event);
        producer.send("payment", new PaymentOrderEvent(event.getOrderId(), 0, TransactionStatus.ROLLBACK));
        producer.send("item", new OrderItemOrderEvent(null, event.getOrderId(), 0, TransactionStatus.ROLLBACK));
        producer.send("inventory", new InventoryOrderEvent(event.getOrderId(), TransactionStatus.ROLLBACK));
    }
}
