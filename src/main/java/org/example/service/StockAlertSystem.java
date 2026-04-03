package org.example.service;

import org.example.interfaces.ISubscriber;
import org.example.models.Product;
import org.example.models.StockAlertData;

import java.util.ArrayList;
import java.util.List;

public class StockAlertSystem {
    private List<ISubscriber> subscribers = new ArrayList<>();

    public void subscribe(ISubscriber sub) {
        subscribers.add(sub);
    }

    public void checkStockLevels(List<Product> products) {
        List<StockAlertData> lowStockItems = new ArrayList<>();

        for (Product p : products) {
            if (p.getQuantity() < 5) { // Threshold logic
                lowStockItems.add(new StockAlertData(p.getName(), p.getQuantity()));
            }
        }

        if (!lowStockItems.isEmpty()) {
            sendAlert(lowStockItems);
        }
    }

    private void sendAlert(List<StockAlertData> data) {
        for (ISubscriber sub : subscribers) {
            sub.notify(data);
        }
    }
}
