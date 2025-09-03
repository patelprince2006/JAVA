import java.util.Scanner;


  class calculator{
      void addition(int a,int b){
         int c=a+b;
         System.out.println(c);
      }
   
      void sub(int a,int b){
         int c=a-b;
         System.out.println(c);
      }
    

      void mul(int a,int b){
         int c=a*b;
         System.out.println(c);
      
      }
       
      void div(int a,int b){
        int c;
        try {
            c=a/0;
        } catch (Exception e) {
            System.out.println(e);
        }
         c=a/b;
         System.out.println(c);
      }
   }

public class calcu{
    public static void main(String[] args) {

     calculator c = new calculator();

      Scanner sc = new Scanner(System.in);
      System.out.println("enter a first number :");
      String value1=sc.next();
      Integer v1 = Integer.parseInt(value1);

      System.out.println("entwer a second number :");
      String value2=sc.next();
      Integer v2 = Integer.parseInt(value2);

      System.out.println("+,-,*,/ :");
      String s=sc.next();
    //   try{
      if(s.equals("+")){
         c.addition(v1,v2);
      }

      else if(s.equals("-")){
         c.sub(v1, v2);
      }

      else if(s.equals("*")){
        c.mul(v1,v2);
      }

      else if(s.equals("/")){
        c.div(v1, v2);
      }
    //   }
    //   catch(Exception: e){
    //     System.out.println("invalid input");
    //   }
    }

}