import java.util.*;

public class PalindromeHighlighter {

    public static String cleanText(String text) {
        return text.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    public static boolean isPalindrome(String text) {
        String cleaned = cleanText(text);
        return cleaned.length() > 1 && cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }

    public static String highlightPalindromeWords(String paragraph) {
        String[] words = paragraph.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (isPalindrome(word)) {
                result.append("**").append(word).append("**").append(" ");
            } else {
                result.append(word).append(" ");
            }
        }

        return result.toString().trim();
    }

    public static String highlightPalindromeSentences(String paragraph) {
        String[] sentences = paragraph.split("(?<=[.!?])\\s*");
        StringBuilder result = new StringBuilder();

        for (String sentence : sentences) {
            if (isPalindrome(sentence)) {
                result.append("**").append(sentence.trim()).append("** ").append(" ");
            } else {
                result.append(sentence.trim()).append(" ");
            }
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a paragraph:");
        String paragraph = sc.nextLine(); 

        System.out.println("\n-- Highlighted Palindrome Words ---");
        System.out.println(highlightPalindromeWords(paragraph));

        System.out.println("\n--- Highlighted Palindrome Sentences ---");
        System.out.println(highlightPalindromeSentences(paragraph));
        System.out.println("24CE092-Prince Patel ");
        sc.close();
    }
}
