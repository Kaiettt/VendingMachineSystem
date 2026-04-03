package org.example.service;

import org.example.interfaces.ISubscriber;
import org.example.models.Product;
import org.example.models.Slot;
import org.example.models.StockAlertData;

import java.util.ArrayList;
import java.util.List;


public class StockAlertSystem {
    private static volatile StockAlertSystem instance;
    private List<ISubscriber> subscribers = new ArrayList<>();
    private static final int OUT_OF_STOCK_THRESHOLD = 5;

    // 1. Private constructor
    private StockAlertSystem() {
        // Khởi tạo sẵn và đăng ký các subscriber tại đây
        this.subscribe(new StaffAlert());
        this.subscribe(new ManagerAlert());

        System.out.println("[System] StockAlertSystem initialized with Staff and Manager alerts.");
    }

    // 2. Double-Checked Locking Singleton
    public static StockAlertSystem getInstance() {
        if (instance == null) {
            synchronized (StockAlertSystem.class) {
                if (instance == null) {
                    instance = new StockAlertSystem();
                }
            }
        }
        return instance;
    }

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