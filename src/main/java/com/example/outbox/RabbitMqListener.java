package com.example.outbox;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

// 실제 메세지 큐는 아니지만 메세지큐 라고 가정
@Component
@Slf4j
public class RabbitMqListener {
    @EventListener
    public void subscribe(OutboxEntity event) {
        log.info("subscribe outBox Entity id = {}", event.getId());
    }
}
