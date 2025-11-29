import java.io.*;

class FileLineCounter extends Thread {
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
            System.out.println(Thread.currentThread().getName() + 
                               " → " + fileName + " has " + lineCount + " lines.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName);
        }
    }
}

public class MultiFileReader {
    public static void main(String[] args) {
 
        FileLineCounter t1 = new FileLineCounter("file1.txt");
        FileLineCounter t2 = new FileLineCounter("file2.txt");
        FileLineCounter t3 = new FileLineCounter("file3.txt");

        t1.setName("Thread-1");
        t2.setName("Thread-2");
        t3.setName("Thread-3");

        t1.start();
        t2.start();
        t3.start();

        try {
            
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All file processing completed.");

        System.out.println("24CE092-Prince Patel ");
    }
}


