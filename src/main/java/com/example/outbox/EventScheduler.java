package com.example.outbox;

import com.example.outbox.domain.OutboxRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EventScheduler {
    private final ApplicationEventPublisher publisher;

    // 메세지 전송 안된 것만 polling
    @Scheduled(fixedDelay = 1000L)
    public void sendMessage() {
        OutboxRepository.OUTBOX_ENTITIES.stream()
                .filter(entity -> !entity.isSent()).forEach(outBoxEntity -> {
                            log.info("polling outBox Entity id = {}", outBoxEntity.getId());
                            publisher.publishEvent(outBoxEntity);
                            outBoxEntity.sendMessage();
                        }
                );
    }
}
