package org.example.service;

import org.example.interfaces.IPaymentStrategy;

public class StudentCardPayment implements IPaymentStrategy {
    String studentId;
    public StudentCardPayment(String id) { this.studentId = id; }
    public boolean collectPayment(double amount) {
        System.out.println("[Payment] Dang tru " + amount + "đ tu the SV: " + studentId);
        return true;
    }
}