package com.example.outbox.domain;


import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class OutboxEntity {
    private UUID id;

    private boolean isSent;

    public OutboxEntity(UUID id) {
        this.id = id;
        this.isSent = false;
    }

    public void sendMessage(){
        this.isSent = true;
    }
}
