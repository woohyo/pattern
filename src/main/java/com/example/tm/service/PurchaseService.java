package com.example.tm.service;

import com.example.tm.factory.IapHandlerFactory;
import com.example.tm.handler.AbstractIapHandler;
import com.example.tm.purchase.Purchase;
import com.example.tm.purchase.PurchaseVerificationCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchaseService {
    private final IapHandlerFactory iapHandlerFactory;

    /* google, apple 등 appstore 를 factory 에서 꺼내 적절한 처리 */
    public void verifyPurchase(PurchaseVerificationCommand command) {
        AbstractIapHandler handler = iapHandlerFactory.findIapStore(command.iapSource());
        /* google, apple 에 알맞은 구매 domain */
        Purchase purchase = handler.verifyTransaction(command);
    }
}
