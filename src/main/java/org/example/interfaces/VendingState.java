package org.example.interfaces;

import org.example.models.VendingMachine;

public interface VendingState {
    void selectItem(VendingMachine vm, String id, int qty) throws Exception;
    void pay(VendingMachine vm, IPaymentStrategy strategy);
    void dispense(VendingMachine vm);
}