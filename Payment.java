import java.util.Scanner;

public class Payment {
    public static void processPayment(Customer customer, Cart cart) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Payment ---");
        cart.displayCart();
        int total = cart.calculateTotal();
        System.out.println("Total: Rp. " + total);
        System.out.print("Masukkan Nama: ");
        String name = scanner.nextLine();

        if (customer == null || !customer.getName().equals(name)) {
            customer = Customer.loadFromFile(name + ".json");
        }

        if (customer == null) {
            System.out.print("Masukkan Email: ");
            String email = scanner.nextLine();
            System.out.print("Masukkan No. HP: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Masukkan Alamat: ");
            String address = scanner.nextLine();
            customer = new Customer(name, email, phoneNumber, address, 0);
        } else {
            System.out.println("Selamat datang kembali, " + customer.getName() + "!");
        }
        System.out.println("Total: Rp. " + total);
        System.out.print("Masukkan uang: ");
        int payment = scanner.nextInt();

        if (payment < total) {
            System.out.println("Uang tidak cukup, pembayaran gagal.");
            System.exit(0);
        } else {
            customer.increaseTransactionCount();
            customer.saveToFile();
            System.out.println("--- Receipt ---");
            System.out.println("Nama: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("No. HP: " + customer.getPhoneNumber());
            System.out.println("Address: " + customer.getAddress());
            System.out.println("Total: Rp. " + total);
            System.out.println("Payment Amount: Rp. " + payment);
            System.out.println("Change: Rp. " + (payment - total));
            System.out.println("Pembayaran berhasil. Terimakasih, " + customer.getName() + "!");
            System.exit(0);
        }
        scanner.close();
    }
}
