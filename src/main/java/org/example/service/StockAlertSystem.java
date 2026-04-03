package org.example.service;

import org.example.interfaces.ISubscriber;
import org.example.models.Product;
import org.example.models.Slot;
import org.example.models.StockAlertData;

import java.util.ArrayList;
import java.util.List;

import static org.example.Common.Common.OUT_OF_STOCK_THRESHOLD;

public class StockAlertSystem {
    private List<ISubscriber> subscribers = new ArrayList<>();

    public void subscribe(ISubscriber sub) {
        subscribers.add(sub);
    }

    public void checkStockLevels(List<Slot> slots) {
        List<StockAlertData> lowStockItems = new ArrayList<>();

        for (Slot slot : slots) {
            if (slot.getQuantity() <= OUT_OF_STOCK_THRESHOLD) {
                lowStockItems.add(new StockAlertData(slot.getQuantity(), slot.getProduct().getName()));
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
