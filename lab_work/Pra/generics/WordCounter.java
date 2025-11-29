import java.util.*;

public class WordCounter {
    public static void main(String[] args) {
        String paragraph = "Java is powerful and Java is versatile. Java is everywhere.";

        paragraph = paragraph.toLowerCase().replaceAll("[^a-z0-9 ]", " ");
        String[] words = paragraph.split("\\s+");

        Map<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
            }
        }
     
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        for (String word : words) {
            if (!linkedHashMap.containsKey(word)) {
                linkedHashMap.put(word, hashMap.get(word));
            }
        }

        Map<String, Integer> treeMap = new TreeMap<>(hashMap);

        System.out.println("🔹 Word Frequency using HashMap (unordered):");
        System.out.println(hashMap);

        System.out.println("\n🔹 Word Frequency using LinkedHashMap (insertion order):");
        System.out.println(linkedHashMap);

        System.out.println("\n🔹 Word Frequency using TreeMap (sorted by word):");
        System.out.println(treeMap);
        System.out.println("24CE092-Prince Patel ");

    }
}


