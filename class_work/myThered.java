
// import com.sun.tools.javac.Main;

public class myThered extends Thread{
     
public void run(){
   try {
       System.out.println(""+myThered.currentThread().getName());
       long mills = 0;
       myThered.sleep(mills,1000);
       System.out.println(Thread.currentThread().getState());
       
   }catch(InterruptedException ex){
    ex.printStackTrace();System.out.println("in run()"+myThered.currentThread().getName());
   }
}
}
public static void main(String args[]) {
    myThered myThread = new myThered();
    Thread t1=new Thread();
    // System.out.println(myThread);
    myThread.setName("Thred-Python");
    t1.start();

    System.out.println(Thread.currentThread().getName()+myThread.getState());
    }