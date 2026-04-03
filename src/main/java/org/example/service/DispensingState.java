package org.example.service;

import org.example.interfaces.IPaymentStrategy;
import org.example.interfaces.VendingState;
import org.example.models.VendingMachine;

public class DispensingState implements VendingState {
    private StockAlertSystem stockAlertSystem = new StockAlertSystem();

    @Override
    public void selectItem(VendingMachine vm, String id, int qty) { System.out.println("[!] Dang nha hang, vui long cho."); }
    @Override
    public void pay(VendingMachine vm, IPaymentStrategy strategy) { System.out.println("[!] Da thanh toan xong."); }

    @Override
    public void dispense(VendingMachine vm) {
        vm.getCart().getItems().forEach((product, qty) -> {
            vm.getInventory().withdrawStock(product.getId(), qty);
        });
        System.out.println("[Done] Moi ban nhan nuoc! Cam on.");
        vm.getCart().getItems().clear();
        // observer here to notify manager,admin about stock of that product
        stockAlertSystem.checkStockLevels(vm.getInventory().getSlots());
        vm.setCurrentState(new ReadyState());
    }
}