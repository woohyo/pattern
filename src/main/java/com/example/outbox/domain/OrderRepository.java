package com.example.outbox.domain;

import org.springframework.stereotype.Repository;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class OrderRepository {
    public static ConcurrentMap<UUID, OrderEntity> ORDER_ENTITIES = new ConcurrentHashMap<>();
}
