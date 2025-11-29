import java.util.Scanner;

class Staff {
    String name;
    int id;
    Staff(String name, int id) {
        this.name = name;
        this.id = id;
    }
    void work() {
        System.out.println("Staff is working...");
    }
}

class Doctor extends Staff {
    String specialization;
    Doctor(String name, int id, String specialization) {
        super(name, id);
        this.specialization = specialization;
    }
    void work() {
        System.out.println("Dr. " + name + " (Specialization: " + specialization +")" + "id: " + id);
    }
}

class Nurse extends Staff {
    Nurse(String name, int id) {
        super(name, id);
    }
    void work() {
        System.out.println("Nurse " + name + "id: " + id);
    }
}

class AdminStaff extends Staff {
    AdminStaff(String name, int id) {
        super(name, id);
    }
    void work() {
        System.out.println("Admin Staff " + name + " id:" +id);
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of staff: ");
        int n = sc.nextInt();
        sc.nextLine();
        Staff[] staffList = new Staff[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter staff type (doctor/nurse/admin): ");
            String type = sc.nextLine().toLowerCase();
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            if (type.equals("doctor")) {
                System.out.print("Enter specialization: ");
                String specialization = sc.nextLine();
                staffList[i] = new Doctor(name, id, specialization);
            } else if (type.equals("nurse")) {
                staffList[i] = new Nurse(name, id);
            } else if (type.equals("admin")) {
                staffList[i] = new AdminStaff(name, id);
            } else {
                System.out.println("Invalid input");
                staffList[i] = new Staff(name, id);
            }
        }
        System.out.println("\n--- Staff Work Details ---");
        for (Staff s : staffList) {
            s.work();
        }
        System.out.println("24CE092-Prince Patel");
        sc.close();
    }
}
