package com.example.saga.inventory;

import com.example.saga.inventory.domain.Inventory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class InventoryService {
    private List<Inventory> myInventory = new ArrayList<>();

    public void add(UUID orderId) {
        Inventory inventory = new Inventory(UUID.randomUUID(), orderId);
        myInventory.add(inventory);
    }

    public void revert(UUID orderId) {
        myInventory.removeIf(inventory -> inventory.getOrderId().equals(orderId));
    }
}
