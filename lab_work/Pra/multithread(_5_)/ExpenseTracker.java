
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ExpenseTracker {
    private static final String LOG_FILE = "expenses_log.txt";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static void addExpense(LocalDate date, String category, double amount, String note) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            String entry = date.format(DATE_FORMAT) + " | " + category + " | " + amount + " | " + note + "\n";
            writer.write(entry);
            System.out.println("✅ Expense added successfully!");
        } catch (IOException e) {
            System.out.println("Error writing expense: " + e.getMessage());
        }
    }

    public static void generateMonthlySummary() {
        Map<String, Double> monthlyTotals = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 3) {
                    String date = parts[0].trim();
                    double amount = Double.parseDouble(parts[2].trim());

                    String month = date.substring(0, 7);
                    monthlyTotals.put(month, monthlyTotals.getOrDefault(month, 0.0) + amount);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading log file: " + e.getMessage());
        }

        try (FileWriter writer = new FileWriter("monthly_summary.txt")) {
            writer.write("📊 Monthly Expense Summary\n");
            for (String month : monthlyTotals.keySet()) {
                writer.write(month + " : " + monthlyTotals.get(month) + "\n");
            }
            System.out.println("✅ Monthly summary generated: monthly_summary.txt");
        } catch (IOException e) {
            System.out.println("Error writing summary: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Expense Tracker ---");
            System.out.println("1. Add Daily Expense");
            System.out.println("2. Generate Monthly Summary");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 1) {
                System.out.print("Enter date (yyyy-MM-dd): ");
                String dateStr = sc.nextLine();
                LocalDate date = LocalDate.parse(dateStr, DATE_FORMAT);

                System.out.print("Enter category (Food/Travel/etc.): ");
                String category = sc.nextLine();

                System.out.print("Enter amount: ");
                double amount = sc.nextDouble();
                sc.nextLine();

                System.out.print("Enter note: ");
                String note = sc.nextLine();

                addExpense(date, category, amount, note);

            } else if (choice == 2) {
                generateMonthlySummary();
            } else if (choice == 3) {
                System.out.println("Goodbye!👋");
                break;
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }

        sc.close();
        System.out.println("24CE092-Prince Patel ");

    }
}


