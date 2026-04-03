package org.example.service;

import org.example.interfaces.IPaymentStrategy;
import org.example.interfaces.VendingState;
import org.example.models.Product;
import org.example.models.VendingMachine;

public class ReadyState implements VendingState {

    @Override
    public void selectItem(VendingMachine vm, String productId, int qty) throws Exception {
        if (vm.getInventory().getTotalStock(productId) >= qty) {
            Product p = vm.getInventory().slots.stream()
                    .filter(s -> s.getProduct().getId().equals(productId)).findFirst().get().getProduct();
            vm.getCart().addItem(p, qty);
            System.out.println("[Ready] Da them " + qty + " " + p.getName() + " vao gio.");
        } else {
            throw new Exception("Not enough quantity in stock");
        }
    }

    @Override
    public void pay(VendingMachine vm, IPaymentStrategy strategy) {
        vm.setPaymentStrategy(strategy);
        vm.setState(new PaymentPendingState());
        vm.confirmPayment();
    }

    @Override
    public void dispense(VendingMachine vm) { System.out.println("[!] Vui long chon mon truoc."); }
}