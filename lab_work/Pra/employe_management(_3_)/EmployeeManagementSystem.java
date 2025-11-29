
class Employee {
   
    private int id;
    private String name;
    private String department;
    private double salary;

    private static int employeeCount = 0;

    
    public Employee() {
        this(0, "Unknown", "General", 0.0); 
    }

    public Employee(int id, String name, String department, double salary) {
        this.id = id;  
        this.name = name;
        this.department = department;
        this.salary = salary;

        employeeCount++;  
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public static int getEmployeeCount() {
        return employeeCount;
    }

    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + 
                           ", Department: " + department + 
                           ", Salary: " + salary);
    }
}

class PermanentEmployee extends Employee {
    private double benefits;

    public PermanentEmployee(int id, String name, String department, double salary, double benefits) {
        super(id, name, department, salary); 
        this.benefits = benefits;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Benefits: " + benefits);
    }
}

class ContractEmployee extends Employee {
    private int contractDuration; 

    public ContractEmployee(int id, String name, String department, double salary, int duration) {
        super(id, name, department, salary);
        this.contractDuration = duration;
    }

    @Override

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Contract Duration: " + contractDuration + " months");
    }
}
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.displayInfo();
        System.out.println();

        Employee e2 = new Employee(92, "Prince ", "HR", 100000);
        e2.displayInfo();
        System.out.println();

        PermanentEmployee pe = new PermanentEmployee(98, "Shivam", "Finance", 60000, 5000);
        pe.displayInfo();
        System.out.println();

        ContractEmployee ce = new ContractEmployee(99, "Vijay", "IT", 40000, 12);
        ce.displayInfo();
        System.out.println();

        System.out.println("Total Employees Created: " + Employee.getEmployeeCount());
        System.out.println();

        if (pe instanceof PermanentEmployee) {
            System.out.println(pe.getName() + " is a Permanent Employee.");
        }
        if (ce instanceof ContractEmployee) {
            System.out.println(ce.getName() + " is a Contract Employee.");
        }
        System.out.println("24CE092-Prince Patel");
    }
}



