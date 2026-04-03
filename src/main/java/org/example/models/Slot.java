package org.example.models;

public class Slot {
    private String slotId;
    private Product product;
    private int quantity;

    public Slot(String slotId, Product product, int quantity) {
        this.slotId = slotId;
        this.product = product;
        this.quantity = quantity;
    }

    public void dispense(int qty) {
        this.quantity -= qty;
        System.out.println("[Machine] Xoay lo xo " + slotId + ": Nha " + qty + " lon " + product.getName());
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}