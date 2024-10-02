package com.example.outbox;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @PostMapping
    public void order() {
        // 주문 이벤트 발행 (생략)

        // 아웃박스 Entity 생성
        OutboxEntity outBoxEntity = new OutboxEntity(UUID.randomUUID());
        OutboxRepository.OUTBOX_ENTITIES.add(outBoxEntity);

        // 메세지 전송 실패
    }
}
