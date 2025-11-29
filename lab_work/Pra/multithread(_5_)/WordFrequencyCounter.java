  import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        String fileName = "input.txt";  

        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase().replaceAll("[^a-z0-9 ]", " ");
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        List<Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());
        sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        System.out.println("🔝 Top 10 Most Frequent Words:");
        for (int i = 0; i < Math.min(10, sortedList.size()); i++) {
            Entry<String, Integer> entry = sortedList.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " → " + entry.getValue() + " times");
        }
        System.out.println("24CE092-Prince Patel ");

    }
}


