package com.example.saga.payment;

import com.example.saga.payment.domain.PaymentException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private int asset = 10000;
    private int revert = 0;
    public void debit(int amount) {
        if (asset < amount) {
            throw new PaymentException("돈이 부족합니다.");
        }
        asset -= amount;
        revert = amount;
    }

    public void rollback() {
        asset += revert;
    }

    public int getAsset() {
        return asset;
    }
}
