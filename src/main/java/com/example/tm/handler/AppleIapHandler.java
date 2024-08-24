package com.example.tm.handler;

import com.example.tm.purchase.IapSource;
import com.example.tm.purchase.Purchase;
import com.example.tm.purchase.PurchaseTransactionResult;
import com.example.tm.purchase.PurchaseVerificationCommand;
import org.springframework.stereotype.Service;

@Service
public class AppleIapHandler extends AbstractIapHandler{

    @Override
    public boolean isApplicable(IapSource iapSource) {
        return iapSource == IapSource.APP_STORE;
    }

    @Override
    protected Purchase saveInitState(PurchaseVerificationCommand command) {
        return null;
    }

    @Override
    protected void verifyIfUnfinishedTransaction(Purchase purchase) {

    }

    @Override
    protected PurchaseTransactionResult getTransactionResult(Purchase purchase) {
        return null;
    }

    @Override
    protected Purchase updatePurchaseState(Purchase purchase, PurchaseTransactionResult transactionResult) {
        return null;
    }

    @Override
    protected void acknowledgePurchase(Purchase updatedPurchase) {

    }

    @Override
    protected void saveTransactionResult(Purchase purchase) {

    }
}
