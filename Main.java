import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        User user = new User("admin", "1234");
        Product[] catalog = {
                new Product(1, "Laptop", 65000),
                new Product(2, "Headphones", 2500),
                new Product(3, "Smartphone", 30000),
                new Product(4, "Power Bank", 1500)
        };

        System.out.println("🛍️ Welcome to JavaCart!");

        // Login
        System.out.print("Username: ");
        String uname = sc.nextLine();
        System.out.print("Password: ");
        String pwd = sc.nextLine();

        if (!user.authenticate(uname, pwd)) {
            System.out.println("❌ Login failed.");
            return;
        }

        System.out.println("✅ Login successful.\n");

        Cart cart = new Cart();
        boolean running = true;

        while (running) {
            System.out.println("\n📦 Product Catalog:");
            for (Product p : catalog) {
                System.out.println(p);
            }

            System.out.println("\nOptions:");
            System.out.println("1. Add to Cart");
            System.out.println("2. View Cart");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter product ID to add: ");
                    int pid = sc.nextInt();
                    if (pid >= 1 && pid <= catalog.length) {
                        cart.addProduct(catalog[pid - 1]);
                    } else {
                        System.out.println("Invalid Product ID.");
                    }
                    break;
                case 2:
                    cart.viewCart();
                    break;
                case 3:
                    if (!cart.isEmpty()) {
                        cart.viewCart();
                        Payment.process(cart.getTotalAmount());
                        running = false;
                    } else {
                        System.out.println("🛒 Cart is empty.");
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

        System.out.println("\n👋 Exiting JavaCart. Have a nice day!");
    }
}
