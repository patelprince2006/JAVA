import java.util.*;

class ProductNotFoundException extends Exception {
    public ProductNotFoundException(String message) {
        super(message);
    }
}

class InsufficientStockException extends RuntimeException {
    public InsufficientStockException(String message) {
        super(message);
    }
}

class Product {
    private int id;
    private String name;
    private int quantity;

    public Product(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }

    public void reduceQuantity(int amount) {
        quantity -= amount;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Quantity: " + quantity);
    }
}

class Inventory {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) {
        products.add(p);
    }

    public void listProducts() {
        for (Product p : products) {
            p.display();
        }
    }

    public void purchaseProduct(int productId, int quantityToPurchase) throws ProductNotFoundException {
        Product product = null;
        for (Product p : products) {
            if (p.getId() == productId) {
                product = p;
                break;
            }
        }

        if (product == null) {
            throw new ProductNotFoundException("Product with ID " + productId + " not found!");
        }

        if (quantityToPurchase > product.getQuantity()) {
            throw new InsufficientStockException("Insufficient stock! Available: " + product.getQuantity());
        }

        product.reduceQuantity(quantityToPurchase);
        System.out.println("Purchased " + quantityToPurchase + " units of " + product.getName());
    }
}

public class InventoryManagementApp {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        inventory.addProduct(new Product(101, "Laptop", 5));
        inventory.addProduct(new Product(102, "Mouse", 10));
        inventory.addProduct(new Product(103, "Keyboard", 7));

        System.out.println("--- Inventory ---");
        inventory.listProducts();

        try {
            inventory.purchaseProduct(102, 3);  
            inventory.purchaseProduct(104, 1);  
        } catch (ProductNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("24CE092-Prince Patel");
    }
}
