package org.example.models;

import org.example.interfaces.IPaymentStrategy;
import org.example.interfaces.VendingState;
import org.example.service.InventoryManager;
import org.example.service.ReadyState;

public class VendingMachine {
    private VendingState currentState = new ReadyState();
    private InventoryManager inventory = new InventoryManager();
    private Cart cart = new Cart();
    private IPaymentStrategy paymentStrategy;


    public VendingState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(VendingState currentState) {
        this.currentState = currentState;
    }

    public InventoryManager getInventory() {
        return inventory;
    }

    public void setInventory(InventoryManager inventory) {
        this.inventory = inventory;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public IPaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }


    public void setState(VendingState state) { this.currentState = state; }
    public void setPaymentStrategy(IPaymentStrategy strategy) { this.paymentStrategy = strategy; }

    public void selectItem(String id, int q) throws Exception { currentState.selectItem(this, id, q); }
    public void insertPayment(IPaymentStrategy s) { currentState.pay(this, s); }
    public void confirmPayment() { currentState.pay(this, paymentStrategy); }
    public void dispense() { currentState.dispense(this); }

}