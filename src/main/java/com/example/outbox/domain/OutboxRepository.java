package com.example.outbox.domain;

import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentLinkedQueue;

@Repository
public class OutboxRepository {
    public static final ConcurrentLinkedQueue<OutboxEntity> OUTBOX_ENTITIES = new ConcurrentLinkedQueue<>();
}
