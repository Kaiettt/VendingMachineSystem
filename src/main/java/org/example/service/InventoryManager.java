package org.example.service;

import org.example.models.Slot;

import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    List<Slot> slots = new ArrayList<>();

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public void addSlot(Slot slot) { slots.add(slot); }

    public int getTotalStock(String productId) {
        return slots.stream()
                .filter(s -> s.getProduct().getId().equals(productId))
                .mapToInt(Slot::getQuantity).sum();
    }

    public void withdrawStock(String productId, int qty) {
        int remaining = qty;
        for (Slot slot : slots) {
            if (remaining <= 0) break;
            if (slot.getProduct().getId().equals(productId) && slot.getQuantity() > 0) {
                int take = Math.min(slot.getQuantity(), remaining);
                slot.dispense(take);
                remaining -= take;
            }
        }
    }
}