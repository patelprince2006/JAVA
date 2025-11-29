
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
class FileLineCounter implements Runnable {
 private String fileName;
 public FileLineCounter(String fileName) {
 this.fileName = fileName;
 }
 @Override
 public void run() {
 int lineCount = 0;
 try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
 while (br.readLine() != null) {
 lineCount++;
 }
 System.out.println("File: " + fileName + " | Lines: " + lineCount);
 } catch (IOException e) {
 System.out.println("Error reading file: " + fileName + " -> " + e.getMessage());
 }
 }
}
public class MultiFileReader {
 public static void main(String[] args) {
 String file1 = "file1.txt";
 String file2 = "file2.txt";
 String file3 = "file3.txt";
 Thread t1 = new Thread(new FileLineCounter(file1));
 Thread t2 = new Thread(new FileLineCounter(file2));
 Thread t3 = new Thread(new FileLineCounter(file3));
 t1.start();
 t2.start();
 t3.start();
 try {
 t1.join();
 t2.join();
 t3.join();
 } catch (InterruptedException e) {
 System.out.println("Thread interrupted: " + e.getMessage());
 }
 System.out.println("All files processed.");
  System.out.println("24ce092 , Prince Patel");
 }

}
