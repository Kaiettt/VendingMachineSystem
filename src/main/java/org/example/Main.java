package org.example;

import org.example.models.Product;
import org.example.models.Slot;
import org.example.models.VendingMachine;
import org.example.service.CashPayment;
import org.example.service.StudentCardPayment;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        VendingMachine vm = new VendingMachine();
        Scanner scanner = new Scanner(System.in);

        setupInventory(vm);

        System.out.println("--- WELCOME TO HCMUTE VENDING MACHINE ---");

        while (true) {
            System.out.println("\n========= MENU CHÍNH =========");
            System.out.println("1. Xem danh sách sản phẩm");
            System.out.println("2. Chọn mua hàng");
            System.out.println("3. Xem giỏ hàng & Thanh toán");
            System.out.println("4. Thoát");
            System.out.print("Mời bạn chọn (1-4): ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    displayInventory(vm);
                    break;
                case 2:
                    System.out.print("Nhập ID sản phẩm (C1, W1...): ");
                    String id = scanner.nextLine();
                    System.out.print("Nhập số lượng: ");
                    int qty = Integer.parseInt(scanner.nextLine());
                    vm.selectItem(id, qty);
                    break;
                case 3:
                    handlePayment(vm, scanner);
                    break;
                case 4:
                    System.out.println("Cảm ơn bạn đã sử dụng dịch vụ!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void setupInventory(VendingMachine vm) {
        Product coca = new Product("C1", "Coca-Cola", 10000, "SoftDrink");
        Product water = new Product("W1", "Nuoc Suoi", 5000, "Water");

        vm.getInventory().addSlot(new Slot("A1", coca, 2));
        vm.getInventory().addSlot(new Slot("A2", coca, 10));
        vm.getInventory().addSlot(new Slot("B1", water, 5));
    }

    private static void displayInventory(VendingMachine vm) {
        System.out.println("\n--- DANH SÁCH KHO HÀNG ---");
        vm.getInventory().getSlots().forEach(slot -> {
            // Thay %d bằng %.0f để in số thực không có chữ số thập phân
            System.out.printf("Vị trí: %s | Tên: %s | Giá: %.0fđ | Còn lại: %d\n",
                    slot.getSlotId(),
                    slot.getProduct().getName(),
                    slot.getProduct().getPrice(),
                    slot.getQuantity());
        });
    }

    private static void handlePayment(VendingMachine vm, Scanner scanner) {
        double total = vm.getCart().calculateTotal();
        if (total <= 0) {
            System.out.println("[!] Giỏ hàng đang trống.");
            return;
        }

        System.out.println("\nTổng tiền cần thanh toán: " + total + "đ");
        System.out.println("Chọn phương thức thanh toán:");
        System.out.println("1. Tiền mặt (Cash)");
        System.out.println("2. Thẻ sinh viên (Student Card)");
        System.out.print("Lựa chọn: ");

        int payChoice = Integer.parseInt(scanner.nextLine());

        if (payChoice == 1) {
            vm.insertPayment(new CashPayment());
        } else if (payChoice == 2) {
            vm.insertPayment(new StudentCardPayment("23110246"));
        } else {
            System.out.println("Phương thức không hợp lệ. Hủy giao dịch.");
        }
    }
}