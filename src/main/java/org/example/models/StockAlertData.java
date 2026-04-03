package org.example.models;
public class StockAlertData {
    private String productName;
    private int currentQuantity;

    public StockAlertData(int currentQuantity, String productName) {
        this.currentQuantity = currentQuantity;
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }
}
