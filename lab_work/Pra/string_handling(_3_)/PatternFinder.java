import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PatternFinder {
public static void findSubstringOccurrences(String text, String pattern) {
int index = 0;
int count = 0;
while ((index = text.indexOf(pattern, index)) != -1) {
System.out.println("Found at index: " + index);
index += pattern.length(); 
count++;
}
System.out.println("Total occurrences: " + count);
}
public static void findRegexOccurrences(String text, String regex) {
Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(text);
int count = 0;
while (matcher.find()) {
System.out.println("Found at index: " + matcher.start());
count++;
}
System.out.println("Total regex matches: " + count);
}
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.println("Enter the large input string:");
String text = sc.nextLine();
System.out.println("Enter the pattern (substring or regex):");
String pattern = sc.nextLine();
System.out.println("\n--- Substring Search ---");
long startTime = System.nanoTime();
findSubstringOccurrences(text, pattern);
long endTime = System.nanoTime();
System.out.println("Time taken: " + (endTime - startTime)/1e6 + " ms");
System.out.println("\n--- Regex Search ---");
startTime = System.nanoTime();
findRegexOccurrences(text, pattern);
endTime = System.nanoTime();
System.out.println("Time taken: " + (endTime - startTime)/1e6 + " ms");
sc.close();
}
}
