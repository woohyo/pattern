package com.example.outbox;

import com.example.outbox.domain.OrderEntity;
import com.example.outbox.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    // Outbox
    @PostMapping
    public UUID order() {
        return orderService.orderEvent();
    }

    // 상품이 부족해서 취소가 되어야 함
    @PostMapping("/cancel/fail/{id}")
    public void failedCancel(@PathVariable UUID id) {
        orderService.failedCancelEvent(id);
    }

    // Outbox
    @PostMapping("/cancel/{id}")
    public void cancel(@PathVariable UUID id) {
        orderService.succeedCancelEvent(id);
    }

    @PostMapping("/delivery/{id}")
    public void delivery(@PathVariable UUID id) {
        orderService.delivery(id);
    }

    @GetMapping("/{id}")
    public OrderEntity get(@PathVariable UUID id) {
        return orderService.findById(id);
    }
}
