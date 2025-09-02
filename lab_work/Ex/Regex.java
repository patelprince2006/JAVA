
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex{
   public static void main(String[] args) {
    
       String mobileNumber= "8726472828";
       String Name="Prince";
       String mobileregex="^[6-9]{9}";
       String Nameregex="^P[a-zA-Z]";
 
    //    Pattern pattern=Pattern.compile(mobileNumber);
       Pattern mobileNumberPattern=Pattern.compile(mobileregex);
       Matcher mobileNumbMatcher=mobileNumberPattern.matcher(mobileNumber);

       Pattern NamPattern=Pattern.compile(Nameregex);
       Matcher NameMatcher=NamPattern.matcher(Name);

       if(NameMatcher.matches()){
          System.out.println("valid");
       }
       else{
           System.out.println("invalid");
       }

       if(mobileNumbMatcher.matches()){
          System.out.println("valid");
       }
       else{
        System.out.println("invalid");
       }

       
   }
}