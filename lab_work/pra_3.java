
import java.util.Scanner;


public class pra_3{
     public static void main(String[] args) {
        String s1;

         Scanner sc=new Scanner(System.in);
         System.out.println("Enter a first string :");
         s1=sc.next();

         System.out.println(s1.toUpperCase());
         System.out.println(s1.stripIndent());
         
         Char c=sc.next();
         System.out.println(s1.replace(c,"*"));

         
     }
} 