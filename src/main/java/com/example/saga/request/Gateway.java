package com.example.saga.request;

import com.example.saga.item.ItemService;
import com.example.saga.item.domain.Item;
import com.example.saga.order.OrderService;
import com.example.saga.payment.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Gateway {
    private final ItemService itemService;
    private final OrderService orderService;
    private final PaymentService paymentService;

    @PostMapping("/item/{price}/{sq}")
    public UUID createItem(
            @PathVariable("price")
            int price,
            @PathVariable("sq")
            int sq
    ) {
        return itemService.createItem(price, sq);
    }

    @PostMapping("/order/{itemId}/{itemCnt}")
    public void order(
            @PathVariable("itemId")
            UUID itemId,
            @PathVariable("itemCnt")
            int itemCnt
    ) {
        orderService.create(itemId, itemCnt);
    }

    @GetMapping("/item/{itemId}")
    public Item getItems(@PathVariable("itemId") UUID itemId) {
        return itemService.findById(itemId);
    }

    @GetMapping("/payment")
    public int asset() {
        return paymentService.getAsset();
    }
}
