package org.example;

import org.example.models.Product;
import org.example.models.Slot;
import org.example.models.VendingMachine;
import org.example.service.CashPayment;
import org.example.service.StudentCardPayment;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        VendingMachine vm = new VendingMachine();

        // Khoi tao du lieu
        Product coca = new Product("C1", "Coca-Cola", 10000, "SoftDrink");
        Product water = new Product("W1", "Nuoc Suoi", 5000, "Water");

        vm.getInventory().addSlot(new Slot("A1", coca, 2)); // Slot A1 co 2 Coca
        vm.getInventory().addSlot(new Slot("A2", coca, 10)); // Slot A2 co 10 Coca
        vm.getInventory().addSlot(new Slot("B1", water, 5));

        System.out.println("--- WELCOME TO HCMUTE VENDING MACHINE ---");

        vm.selectItem("C1", 12); // Chon 3 Coca (Lay 2 tu A1, 1 tu A2)
        vm.selectItem("W1", 5); // Chon 1 Nuoc suoi

        System.out.println("Tong tien: " + vm.getCart().calculateTotal() + "đ");

        // Thanh toan bang the sinh vien
        vm.insertPayment(new CashPayment());
    }
}