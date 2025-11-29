import java.util.*;

class Student {
    private int id;
    private String name;
    private int marks;

    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() { return id; }
    public int getMarks() { return marks; }
    public String getName() { return name; }

    public void displayInfo() {
        System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
    }
}

class StudentUtility {
    public static boolean validateMarks(int marks) {
        return marks >= 0 && marks <= 100;
    }

    public static String calculateGrade(int marks) {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 50) return "C";
        else return "F";
    }
}

class StudentService {
    private List<Student> students = new ArrayList<>();

    public void registerStudent(int id, String name, int marks) {
        if (StudentUtility.validateMarks(marks)) {
            students.add(new Student(id, name, marks));
            System.out.println(" Student Registered: " + name);
        } else {
            System.out.println(" Invalid marks for " + name);
        }
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }
        for (Student s : students) {
            s.displayInfo();
            System.out.println("Grade: " + StudentUtility.calculateGrade(s.getMarks()));
            System.out.println("-------------------");
        }
    }

    public void searchById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("Student Found:");
                s.displayInfo();
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }
}

public class StudentManagementApp {
    public static void main(String[] args) {
        StudentService service = new StudentService();

        service.registerStudent(101, "prince", 85);
        service.registerStudent(102, "shivam", 45);
        service.registerStudent(103, "vijay", 92);

        System.out.println("\n--- All Students ---");
        service.listStudents();

        System.out.println("\n--- Search Student ---");
        service.searchById(102);
         System.out.println("24CE092-Prince Patel");
    }
}
