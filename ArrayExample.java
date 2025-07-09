import java.util.Scanner;

public class ArrayExample{
    public static void main(String[] args) {
        Object o[]= new Object[3];
        for(int i=0;i<o.length;i++){
        Scanner Sc= new Scanner(System.in);
        System.out.print("Enter Id: ");
        int id = Sc.nextInt();
         System.out.print("Enter name: ");
         String name = Sc.next();
          System.out.print("Enter Sub 1: ");
          int Sub_1 = Sc.nextInt();
           System.out.print("Enter Sub 2: ");
           int Sub_2 =Sc.nextInt();
            System.out.print("Enter Sub 3: ");
            int Sub_3 = Sc.nextInt();
        
        student s = new student(id,name,Sub_1,Sub_2,Sub_3);
        System.out.println(s);
    }
}
}
