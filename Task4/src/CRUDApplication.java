import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class CRUDApplication {

    private static final List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        // Create a Scanner object to read user input.
        Scanner scanner = new Scanner(System.in);

        // Display the menu.
        System.out.println("What would you like to do?");
        System.out.println("1. Create a product");
        System.out.println("2. Read a product");
        System.out.println("3. Update a product");
        System.out.println("4. Delete a product");
        System.out.println("5. Exit");

        // Get the user's choice.
        int choice = scanner.nextInt();

        // Switch on the user's choice.
        switch (choice) {
            case 1:
                // Create a product.
                System.out.println("Enter the product name: ");
                String name = scanner.next();
                System.out.println("Enter the product price: ");
                double price = scanner.nextDouble();
                products.add(new Product(name, price));
                break;
            case 2:
                // Read a product.
                System.out.println("Enter the product ID: ");
                int id = scanner.nextInt();
                Product product = products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
                if (product != null) {
                    System.out.println("Product name: " + product.getName());
                    System.out.println("Product price: " + product.getPrice());
                } else {
                    System.out.println("Product not found");
                }
                break;
            case 3:
                // Update a product.
                System.out.println("Enter the product ID: ");
                id = scanner.nextInt();
                product = products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
                if (product != null) {
                    System.out.println("Enter the new product name: ");
                    name = scanner.next();
                    System.out.println("Enter the new product price: ");
                    price = scanner.nextDouble();
                    product.setName(name);
                    product.setPrice(price);
                } else {
                    System.out.println("Product not found");
                }
                break;
            case 4:
                // Delete a product.
                System.out.println("Enter the product ID: ");
                id = scanner.nextInt();
                products.removeIf(p -> p.getId() == id);
                break;
            case 5:
                // Exit the application.
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}

class Product {

    private int id;
    private String name;
    private double price;
	private List<Product> products;

    public Product(String name, double price) {
        this.id = products.size() + 1;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
