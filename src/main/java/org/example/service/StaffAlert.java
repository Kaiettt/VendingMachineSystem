package org.example.service;

import org.example.interfaces.ISubscriber;
import org.example.models.StockAlertData;

import java.util.List;

public class StaffAlert implements ISubscriber {
    @Override
    public void notify(List<StockAlertData> dataList) {
        System.out.println("--- STAFF ALERT: LOW STOCK DETECTED ---");
        for (StockAlertData item : dataList) {
            System.out.println("Product: " + item.getProductName() +
                    " | Remaining: " + item.getCurrentQuantity());
        }
        System.out.println("---------------------------------------");
    }
}
