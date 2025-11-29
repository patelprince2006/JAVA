
import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.FIELD)           
@interface VehicleInfo {
    String value() default "Important Vehicle Field";
}

abstract class Vehicle {
    @VehicleInfo("Registration Number")
    private final String regNumber; 

    @VehicleInfo("Owner Name")
    private String owner;

    public Vehicle(String regNumber, String owner) {
        this.regNumber = regNumber;
        this.owner = owner;
    }

    public final String getRegNumber() {  
        return regNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public abstract void displayDetails();
}

class Car extends Vehicle {
    @VehicleInfo("Car Model")
    private String model;

    public Car(String regNumber, String owner, String model) {
        super(regNumber, owner);
        this.model = model;
    }

    @Override
    public void displayDetails() {
        System.out.println("Car [Reg: " + getRegNumber() + ", Owner: " + getOwner() + ", Model: " + model + "]");
    }
}

class Bike extends Vehicle {
    @VehicleInfo("Bike Type")
    private String type;

    public Bike(String regNumber, String owner, String type) {
        super(regNumber, owner);
        this.type = type;
    }

    @Override
    public void displayDetails() {
        System.out.println("Bike [Reg: " + getRegNumber() + ", Owner: " + getOwner() + ", Type: " + type + "]");
    }
}

class Truck extends Vehicle {
    @VehicleInfo("Truck Capacity (tons)")
    private int capacity;

    public Truck(String regNumber, String owner, int capacity) {
        super(regNumber, owner);
        this.capacity = capacity;
    }

    @Override
    public void displayDetails() {
        System.out.println("Truck [Reg: " + getRegNumber() + ", Owner: " + getOwner() + ", Capacity: " + capacity + " tons]");
    }
}

final class VehicleUtils {
    private VehicleUtils() {} 

    public static final void printAnnotatedFields(Object obj) {
        Class<?> clazz = obj.getClass();
        System.out.println("\nAnnotated Fields for " + clazz.getSimpleName() + ":");
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(VehicleInfo.class)) {
                VehicleInfo info = field.getAnnotation(VehicleInfo.class);
                field.setAccessible(true);
                try {
                    System.out.println(info.value() + " → " + field.get(obj));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class VehicleRegistrationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vehicles to register: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("\nChoose Vehicle Type (1. Car, 2. Bike, 3. Truck): ");
            int choice = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Registration Number: ");
            String reg = sc.nextLine();

            System.out.print("Enter Owner Name: ");
            String owner = sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Car Model: ");
                    String model = sc.nextLine();
                    vehicles.add(new Car(reg, owner, model));
                    break;
                case 2:
                    System.out.print("Enter Bike Type: ");
                    String type = sc.nextLine();
                    vehicles.add(new Bike(reg, owner, type));
                    break;
                case 3:
                    System.out.print("Enter Truck Capacity (tons): ");
                    int capacity = sc.nextInt();
                    sc.nextLine();
                    vehicles.add(new Truck(reg, owner, capacity));
                    break;
                default:
                    System.out.println("Invalid choice!");
                    i--; 
            }
        }

        for (Vehicle v : vehicles) {
            v.displayDetails();
            VehicleUtils.printAnnotatedFields(v);
        }
        
        System.out.println("/n/n");
        System.out.println("24CE122-Fayan-Suthar");

        sc.close();
    }
}



