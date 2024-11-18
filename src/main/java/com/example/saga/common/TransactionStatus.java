package com.example.saga.common;

public enum TransactionStatus {
    PENDING,
    ROLLBACK,
    COMMIT,
    PROCESS
}
