package org.example.service;

import org.example.interfaces.IPaymentStrategy;

public class CashPayment implements IPaymentStrategy {
    public boolean collectPayment(double amount) {
        System.out.println("[Payment] Da nhan " + amount + "đ tien mat.");
        return true;
    }
}