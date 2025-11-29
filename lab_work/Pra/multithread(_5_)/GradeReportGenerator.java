import java.io.*;
import java.util.*;

class Student {
    String name;
    List<Integer> marks;
    double average;
    String grade;

    Student(String name, List<Integer> marks) {
        this.name = name;
        this.marks = marks;
        this.average = calculateAverage();
        this.grade = assignGrade();
    }

    private double calculateAverage() {
        int sum = 0;
        for (int mark : marks) sum += mark;
        return (double) sum / marks.size();
    }

    private String assignGrade() {
        if (average >= 85) return "A";
        else if (average >= 70) return "B";
        else if (average >= 55) return "C";
        else if (average >= 40) return "D";
        else return "F";
    }

    void printReport() {
        System.out.println("----------- Grade Report -----------");
        System.out.println("Student: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("------------------------------------\n");
    }
}

public class GradeReportGenerator {
    public static void main(String[] args) {
        String filename = "students.txt";  

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                
                String name = data[0].trim();

                List<Integer> marks = new ArrayList<>();
                for (int i = 1; i < data.length; i++) {
                    marks.add(Integer.parseInt(data[i].trim()));
                }

                Student student = new Student(name, marks);

                student.printReport();
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        System.out.println("\n\n24CE092-Prince Patel ");

    }
}


