// Thread by extending Thread class
class NumberThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Number: " + i);
            try {
                Thread.sleep(1000); // 1-second delay
            } catch (InterruptedException e) {
                System.out.println("NumberThread interrupted");
            }
        }
    }
}

// Thread by implementing Runnable interface
class LetterRunnable implements Runnable {
    public void run() {
        for (char ch = 'A'; ch <= 'E'; ch++) {
            System.out.println("Letter: " + ch);
            try {
                Thread.sleep(1000); // 1-second delay
            } catch (InterruptedException e) {
                System.out.println("LetterRunnable interrupted");
            }
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        // Create and start NumberThread
        NumberThread numberThread = new NumberThread();
        numberThread.start();

        // Create and start LetterRunnable thread
        Thread letterThread = new Thread(new LetterRunnable());
        letterThread.start();
    }
}