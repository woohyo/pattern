package com.example.saga.item.event;

import com.example.saga.common.TransactionStatus;
import com.example.saga.item.ItemService;
import com.example.saga.item.domain.Item;
import com.example.saga.item.domain.ItemException;
import com.example.saga.order.event.OrderCreateEvent;
import com.example.saga.payment.event.PaymentOrderEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ItemConsumer {
    private final ItemService itemService;
    private final ApplicationEventPublisher publisher;
    public void consume(OrderItemOrderEvent event) {
        if (event.getStatus().equals(TransactionStatus.PROCESS)) {
            try {
                Item byId = itemService.findById(event.getId());
                int amount = byId.getPrice() * event.getCnt();
                publisher.publishEvent(new PaymentOrderEvent(event.getOrderId(), amount, event.getStatus()));
                itemService.order(event.getId(), event.getCnt());
            } catch (ItemException e) {
                publisher.publishEvent(new OrderCreateEvent(event.getOrderId(), TransactionStatus.ROLLBACK));
            }
        } else if (event.getStatus().equals(TransactionStatus.ROLLBACK)) {
            itemService.rollback();
        }
    }
}
