
interface Exam{
    boolean pass(int marks);
}

interface Classify{
   public string Division(int average);
}

class Result implements Exam,Classify{
     public boolean pass(int marks){
        if(marks>=50){
            return true;
        }
        else{
            return false;
        }
     }

    public string Division(int average){
        if(average>=60){
            return "first";
        }
        else if(average>=50 && average<=60){
            return "second";
        }
        else{
            return "fail";
        }
     }
}

public static void main(String[]argds){
     Result result=new Result();
     result.pass(30);
     result.Division(40);
     System.out.println(result);
}