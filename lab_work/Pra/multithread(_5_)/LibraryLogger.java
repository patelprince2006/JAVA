	import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LibraryLogger {
    private static final String LOG_FILE = "library_log.txt";

    public static void logAction(String studentName, String bookTitle, String action) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timestamp = LocalDateTime.now().format(dtf);

            String logEntry = timestamp + " | " + action + " | Student: " + studentName 
                            + " | Book: " + bookTitle + "\n";

            writer.write(logEntry);
            System.out.println("✅ Logged: " + logEntry);
        } catch (IOException e) {
            System.out.println("Error writing to log file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Logging System ---");
            System.out.println("1. Issue a Book");
            System.out.println("2. Return a Book");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 1) {
                System.out.print("Enter student name: ");
                String studentName = sc.nextLine();
                System.out.print("Enter book title: ");
                String bookTitle = sc.nextLine();
                logAction(studentName, bookTitle, "ISSUE");
            } 
            else if (choice == 2) {
                System.out.print("Enter student name: ");
                String studentName = sc.nextLine();
                System.out.print("Enter book title: ");
                String bookTitle = sc.nextLine();
                logAction(studentName, bookTitle, "RETURN");
            } 
            else if (choice == 3) {
                System.out.println("Exiting system. Goodbye!");
                break;
            } 
            else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
        System.out.println("24CE092-Prince Patel ");

    }
}


