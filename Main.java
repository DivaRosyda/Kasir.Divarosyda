import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Cart cart = new Cart();
        Customer customer = null;

        System.out.println("Selamat datang di toko Diva\n");

        while (true) {
            System.out.println("List Item:");
            menu.displayMenu();
            System.out.println("98. Cart");
            System.out.println("99. Menu Pembayaran");
            System.out.println("0. Keluar");

            System.out.print("Pilih menu: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Program Keluar");
                break;
            } else if (choice == 98) {
                System.out.println("--- Cart ---");
                cart.displayCart();
            } else if (choice == 99) {
                Payment.processPayment(customer, cart);
                // cart = new Cart();
            } else {
                MenuItem menuItem = menu.getMenuItem(choice);
                if (menuItem != null) {
                    cart.addItem(menuItem);
                    System.out.println(menuItem.getName() + " ditambahkan ke cart");
                } else {
                    System.out.println("Menu tidak valid");
                }
            }

            System.out.println();
        }
        scanner.close();
    }
}
