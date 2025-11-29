class NumberThread extends Thread {
 @Override
 public void run() {
 for (int i = 1; i <= 5; i++) {
 System.out.println(i);
 try {
 Thread.sleep(1000);
 } catch (InterruptedException e) {
 System.out.println("NumberThread interrupted");
 }
 }
 }
}
class LetterRunnable implements Runnable {
 @Override
 public void run() {
 for (char c = 'A'; c <= 'E'; c++) {
 System.out.println(c);
 try {
 Thread.sleep(1000);
 } catch (InterruptedException e) {
 System.out.println("LetterRunnable interrupted");
 }
 }
 }
}
public class ThreadDemo {
 public static void main(String[] args) {
 NumberThread numberThread = new NumberThread();
 Thread letterThread = new Thread(new LetterRunnable());
 numberThread.start();
 letterThread.start();
 System.out.println("24ce092 , Prince Patel");
 }
}