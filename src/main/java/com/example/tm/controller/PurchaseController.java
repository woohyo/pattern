package com.example.tm.controller;

import com.example.tm.purchase.IapSource;
import com.example.tm.purchase.PurchaseVerificationCommand;
import com.example.tm.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/purchase")
@RequiredArgsConstructor
public class PurchaseController {
    private final PurchaseService purchaseService;

    @GetMapping("/verify")
    public void verifyPurchase(){
        PurchaseVerificationCommand command = new PurchaseVerificationCommand(IapSource.GOOGLE_PLAY);
        purchaseService.verifyPurchase(command);
    }
}
