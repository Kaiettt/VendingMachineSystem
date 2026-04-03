package org.example.models;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items = new HashMap<>();
    public void addItem(Product p, int q) { items.put(p, items.getOrDefault(p, 0) + q); }
    public double calculateTotal() { return items.entrySet().stream().mapToDouble(e -> e.getKey().getPrice() * e.getValue()).sum(); }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public void setItems(Map<Product, Integer> items) {
        this.items = items;
    }
}