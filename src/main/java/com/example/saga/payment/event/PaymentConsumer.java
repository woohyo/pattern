package com.example.saga.payment.event;

import com.example.saga.common.TransactionStatus;
import com.example.saga.order.event.OrderCreateEvent;
import com.example.saga.payment.PaymentService;
import com.example.saga.payment.domain.PaymentException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentConsumer {
    private final PaymentService paymentService;
    private ApplicationEventPublisher publisher;

    public void consume(PaymentOrderEvent event) {
        if (event.getStatus().equals(TransactionStatus.PROCESS)) {
            try {
                paymentService.debit(event.amount);
            } catch (PaymentException e) {
                publisher.publishEvent(new OrderCreateEvent(event.orderId, TransactionStatus.ROLLBACK));
            }
        } else if (event.getStatus().equals(TransactionStatus.ROLLBACK)) {
            paymentService.rollback();
        }
    }
}
