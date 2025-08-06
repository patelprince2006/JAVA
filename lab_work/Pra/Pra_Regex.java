
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Pra_Regex{
    public static void main(String[] args) {
        int count=0;
        String s="envenebrffuenbufb";
        String sregex="en";

        Pattern sPattern=Pattern.compile(sregex);
        Matcher sMatcher=sPattern.matcher(s);

        String replace= s.replace("en","**");

        while(sMatcher.find()){
             count++;
        }

        System.out.println(count);
        System.out.println(replace);
    }
}
