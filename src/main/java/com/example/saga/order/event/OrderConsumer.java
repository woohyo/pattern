package com.example.saga.order.event;

import com.example.saga.common.TransactionStatus;
import com.example.saga.orchestrator.OrderEvent;
import com.example.saga.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OrderConsumer {
    private final OrderService orderService;
    public void consume(OrderCreateEvent event) {
        if (event.getStatus().equals(TransactionStatus.ROLLBACK)) {
            orderService.rollback(event.orderId);
        }
    }
}
