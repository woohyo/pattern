package com.example.outbox.domain;


import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class OutboxEntity {
    private UUID id;
    private UUID orderId;

    private boolean isSent;

    public OutboxEntity(UUID id, UUID orderId) {
        this.id = id;
        this.orderId = orderId;
        this.isSent = false;
    }

    public void sendMessage(){
        this.isSent = true;
    }
}
