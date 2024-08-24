package com.example.tm.handler;

import com.example.tm.purchase.IapSource;
import com.example.tm.purchase.Purchase;
import com.example.tm.purchase.PurchaseTransactionResult;
import com.example.tm.purchase.PurchaseVerificationCommand;

// in-app 결제 알고리즘의 뼈대 작성
public abstract class AbstractIapHandler {
    public abstract boolean isApplicable(IapSource iapSource);

    protected abstract Purchase saveInitState(PurchaseVerificationCommand command);

    protected abstract void verifyIfUnfinishedTransaction(Purchase purchase);

    protected abstract PurchaseTransactionResult getTransactionResult(Purchase purchase);

    protected abstract Purchase updatePurchaseState(Purchase purchase, PurchaseTransactionResult transactionResult);

    protected abstract void acknowledgePurchase(Purchase updatedPurchase);

    protected abstract void saveTransactionResult(Purchase purchase);

    /* Template method 알고리즘의 순서만 정의 한다 */
    public Purchase verifyTransaction(PurchaseVerificationCommand command) {
        Purchase purchase = saveInitState(command);
        verifyIfUnfinishedTransaction(purchase);
        PurchaseTransactionResult transactionResult = getTransactionResult(purchase);
        Purchase updatedPurchase = updatePurchaseState(purchase, transactionResult);
        acknowledgePurchase(updatedPurchase);
        saveTransactionResult(updatedPurchase);
        return updatedPurchase;
    }
}
