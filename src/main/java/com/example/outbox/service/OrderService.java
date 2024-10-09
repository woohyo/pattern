package com.example.outbox.service;

import com.example.outbox.domain.OrderEntity;
import com.example.outbox.domain.OrderRepository;
import com.example.outbox.domain.OutboxEntity;
import com.example.outbox.domain.OutboxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

// 모든 method 는 transactional 하게 동작
@Service
@RequiredArgsConstructor
public class OrderService {
    private final MessageService messageService;

    public UUID orderEvent() {
        // order 에 대한 이벤트 처리
        OrderEntity orderEntity = OrderEntity.create();
        OrderRepository.ORDER_ENTITIES.put(orderEntity.getId(), orderEntity);
        // 아웃박스 Entity 생성
        OutboxEntity outBoxEntity = new OutboxEntity(UUID.randomUUID(), orderEntity.getId());
        OutboxRepository.OUTBOX_ENTITIES.add(outBoxEntity);
        return orderEntity.getId();
    }

    public void delivery(UUID orderId) {
        OrderRepository.ORDER_ENTITIES.computeIfPresent(orderId, (id, entity) -> {
            entity.delivery();
            return entity;
        });
    }

    // event 진입점이라면 큰 문제는 없음
    // 재고 부족으로 상품 서비스에서 호출한다고 가정 -> 문제
    public void failedCancelEvent(UUID orderId) {
        OrderRepository.ORDER_ENTITIES.computeIfPresent(orderId, (id, entity) -> {
            entity.cancel();
            return entity;
        });

        try {
            messageService.failedSendMessage();
        } catch (RuntimeException e) {
            OrderRepository.ORDER_ENTITIES.computeIfPresent(orderId, (id, entity) -> {
                entity.rollback();
                return entity;
            });
        }
    }

    public void succeedCancelEvent(UUID orderId) {
        OrderRepository.ORDER_ENTITIES.computeIfPresent(orderId, (id, entity) -> {
            entity.cancel();
            return entity;
        });

        OutboxEntity outboxEntity = new OutboxEntity(UUID.randomUUID(), orderId);
        OutboxRepository.OUTBOX_ENTITIES.add(outboxEntity);
    }

    public OrderEntity findById(UUID id) {
        return OrderRepository.ORDER_ENTITIES.get(id);
    }
}
