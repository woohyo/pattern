package com.example.outbox.otherserver;

import com.example.outbox.domain.OutboxEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

// 실제 메세지 큐는 아니지만 메세지큐 라고 가정
// 다른 서비스에서 이벤트 소비
@Component
@Slf4j
public class RabbitMqListener {
    @EventListener
    public void subscribe(OutboxEntity event) {
        // 이벤트를 받은 다른 서버에서 처리
        log.info("{} 에 대한 상품 재고 조정", event.getOrderId());
        log.info("{} 에 대한 금액 입금(환불)", event.getOrderId());
    }
}
