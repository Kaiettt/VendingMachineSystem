package org.example.models;
public class StockAlertData {
    private String productName;
    private String currentQuantity;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(String currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public StockAlertData(String productName, String currentQuantity) {
        this.productName = productName;
        this.currentQuantity = currentQuantity;
    }
}
