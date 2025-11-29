	import java.util.*;

public class CorruptSignalProcessor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();
        sc.close();

        String[] signals = inputLine.split("\\s+");
        int sum = 0;
        int corruptCount = 0;

        for (String signal : signals) {
            try {
                int value = Integer.parseInt(signal);
                if (value < 1 || value > 1000) {
                    throw new IllegalArgumentException("Out of range: " + value);
                }
                sum += value; 
            } catch (NumberFormatException e) {
                corruptCount++; 
            } catch (IllegalArgumentException e) {
                corruptCount++; 
            }
        }

        System.out.println(sum);
        System.out.println(corruptCount);

        System.out.println("24CE092-Prince Patel ");
    }
}


