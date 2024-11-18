package com.example.saga.item;

import com.example.saga.item.domain.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final List<Item> items = new ArrayList<>();
    private UUID rollbackId;
    private int rollbackSq;

    public UUID createItem(int price, int sq) {
        Item item = new Item(UUID.randomUUID(), price, sq);
        items.add(item);
        return item.getId();
    }

    public Item findById(UUID itemId) {
        return items.stream().filter(i -> i.getId().equals(itemId)).findFirst().get();
    }

    public void order(UUID itemId, int sq) {
        for (Item item : items) {
            if (item.getId().equals(itemId)) {
                item.decrement(sq);
                rollbackId = itemId;
                rollbackSq = sq;
            }
        }
    }

    public void rollback() {
        for (Item item : items) {
            if (item.getId().equals(rollbackId)) {
                item.increment(rollbackSq);
            }
        }
    }
}
