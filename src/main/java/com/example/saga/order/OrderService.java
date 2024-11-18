package com.example.saga.order;

import com.example.saga.common.TransactionStatus;
import com.example.saga.order.domain.Order;
import com.example.saga.order.domain.OrderStatus;
import com.example.saga.order.event.OrderCreateEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private List<Order> orders = new ArrayList<>();
    private final ApplicationEventPublisher publisher;
    public void create(UUID itemId, int itemCnt) {
        Order order = new Order(UUID.randomUUID(), itemId, itemCnt, OrderStatus.PENDING);
        orders.add(order);
        OrderCreateEvent orderCreateEvent = new OrderCreateEvent(order.getId(), TransactionStatus.PROCESS);
        orderCreateEvent.setItemId(itemId);
        orderCreateEvent.setItemCnt(itemCnt);
        publisher.publishEvent(orderCreateEvent);
    }

    public Order findById(UUID orderId) {
        return orders.stream().filter(i -> i.getId().equals(orderId)).findFirst().get();
    }

    public void rollback(UUID orderId) {
        orders.removeIf(order -> order.getId().equals(orderId));
    }
}
