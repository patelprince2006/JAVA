

public class string{
     public static void main(String[] args) {
         String s1= "prince    patel    ";
         String s2= "   vijay";
         String s3="prince";

         System.out.println(s1.charAt(2));
         System.out.println(s1.chars());
         System.out.println(s1.isEmpty());
         System.out.println(s1.isBlank());
         System.out.println(s1.intern());
         System.out.println(s1.getClass());
         System.out.println(s1.describeConstable());
         System.out.println(s1.split(s2));
         System.out.println(s1.stripIndent());
         System.out.println(s2.stripIndent());
         System.out.println(s1.matches(s2));
         System.out.println(s1.strip());
           System.out.println(s1.stripLeading());
           System.out.println(s1.stripTrailing());
        System.out.println(s1.startsWith(s3));
        System.out.println(s1.split(s2));
        System.out.println(s1);
     }
}