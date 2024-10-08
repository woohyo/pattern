package com.example.outbox.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    public void failedSendMessage() {
        throw new RuntimeException();
    }
}
