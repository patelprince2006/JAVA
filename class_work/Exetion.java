
class licence extends Exception{
   public licence(int age){
       System.out.println("you are eligible for licence");
     }
}
public class Exetion{
    public static void main(String[] args) {
        int age=56;
        try {
            throw new licence(age);
        } catch (Exception e) {
            System.out.println("you are not eligible for licence");
        }
    }
}