  import java.util.*;

interface Sellable {
    double getPrice();
    String getName();
}

class InventoryItem<T extends Sellable> {
    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public void updateItem(int index, T item) {
        if (index >= 0 && index < items.size()) {
            items.set(index, item);
        }
    }

    public void deleteItem(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        }
    }

    public List<T> getItems() {
        return items;
    }
}

class Electronics implements Sellable {
    private String name;
    private double price;

    public Electronics(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() { return price; }
    public String getName() { return name; }

    public String toString() {
        return name + " ($" + price + ")";
    }
}

class Clothing implements Sellable {
    private String name;
    private double price;

    public Clothing(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() { return price; }
    public String getName() { return name; }

    public String toString() {
        return name + " ($" + price + ")";
    }
}

class Groceries implements Sellable {
    private String name;
    private double price;

    public Groceries(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() { return price; }
    public String getName() { return name; }

    public String toString() {
        return name + " ($" + price + ")";
    }
}

class InventoryUtils {
    public static double calculateTotalValue(List<? extends Sellable> items) {
        double total = 0;
        for (Sellable item : items) {
            total += item.getPrice();
        }
        return total;
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryItem<Electronics> electronicsInventory = new InventoryItem<>();
        InventoryItem<Clothing> clothingInventory = new InventoryItem<>();
        InventoryItem<Groceries> groceriesInventory = new InventoryItem<>();

        electronicsInventory.addItem(new Electronics("Laptop", 1200));
        electronicsInventory.addItem(new Electronics("Smartphone", 800));

        clothingInventory.addItem(new Clothing("T-Shirt", 25));
        clothingInventory.addItem(new Clothing("Jeans", 50));

        groceriesInventory.addItem(new Groceries("Milk", 3));
        groceriesInventory.addItem(new Groceries("Bread", 2));

        electronicsInventory.updateItem(1, new Electronics("Smartphone Pro", 950));
        clothingInventory.deleteItem(0);

        System.out.println("Electronics: " + electronicsInventory.getItems());
        System.out.println("Clothing: " + clothingInventory.getItems());
        System.out.println("Groceries: " + groceriesInventory.getItems());

        double totalValue = InventoryUtils.calculateTotalValue(electronicsInventory.getItems())
                + InventoryUtils.calculateTotalValue(clothingInventory.getItems())
                + InventoryUtils.calculateTotalValue(groceriesInventory.getItems());

        System.out.println("Total Inventory Value: $" + totalValue);

        
        System.out.println("24CE092-Prince Patel ");

    }
}


