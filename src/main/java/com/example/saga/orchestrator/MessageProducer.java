package com.example.saga.orchestrator;

import com.example.saga.inventory.event.InventoryConsumer;
import com.example.saga.inventory.event.InventoryOrderEvent;
import com.example.saga.item.event.ItemConsumer;
import com.example.saga.item.event.OrderItemOrderEvent;
import com.example.saga.order.event.OrderConsumer;
import com.example.saga.order.event.OrderCreateEvent;
import com.example.saga.payment.event.PaymentConsumer;
import com.example.saga.payment.event.PaymentOrderEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageProducer {
    private final ItemConsumer itemConsumer;
    private final PaymentConsumer paymentConsumer;
    private final InventoryConsumer inventoryConsumer;
    private final OrderConsumer orderConsumer;
    public void send(String topic, Object event) {
        if (topic.startsWith("order")) {
            orderConsumer.consume((OrderCreateEvent) event);
        } else if (topic.startsWith("payment")) {
            paymentConsumer.consume((PaymentOrderEvent) event);
        } else if (topic.startsWith("inventory")) {
            inventoryConsumer.consume((InventoryOrderEvent) event);
        } else if (topic.startsWith("item")) {
            itemConsumer.consume((OrderItemOrderEvent) event);
        } else {
            System.out.println("error");
        }
    }
}
