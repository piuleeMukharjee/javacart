import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> products;

    public Cart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println(product + " added to the cart.");
    }

    public void viewCart() {
        if (products.isEmpty()) {
            System.out.println("🛒 Your cart is empty.");
        } else {
            System.out.println("Your Cart:");
            for (Product product : products) {
                System.out.println(product);
            }
            System.out.println("Total Amount: ₹" + getTotalAmount());
        }
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public double getTotalAmount() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice(); // This is where the error occurred
        }
        return total;
    }
}
