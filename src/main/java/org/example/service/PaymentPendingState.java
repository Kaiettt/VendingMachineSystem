package org.example.service;

import org.example.interfaces.IPaymentStrategy;
import org.example.interfaces.VendingState;
import org.example.models.VendingMachine;

public class PaymentPendingState implements VendingState {

    @Override
    public void selectItem(VendingMachine vm, String id, int qty) { System.out.println("[!] Dang thanh toan, khong the chon them."); }

    @Override
    public void pay(VendingMachine vm, IPaymentStrategy strategy) {
        if (vm.getPaymentStrategy().collectPayment(vm.getCart().calculateTotal())) {
            vm.setCurrentState(new DispensingState());
            vm.dispense();
        }
        else{
            // roll back everything
        }
    }

    @Override
    public void dispense(VendingMachine vm) { System.out.println("[!] Cho xac nhan thanh toan."); }
}