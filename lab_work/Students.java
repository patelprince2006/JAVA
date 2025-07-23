import java.util.Scanner;

public class Students{
     int rollno;
    String name;

   void student_data(){
        Scanner sc= new Scanner(System.in);
        System.out.print("enter a id :");
        int id= sc.nextInt();
        System.out.print("enter a name :");
        String name=sc.next();
   }

    public class Course{
         String course;
        
        void add_Course(){
         Scanner s=new Scanner(System.in);
         System.out.print("enter a course :");
         String course= s.next();
       }

       void data(){
           System.out.println("student id:"+rollno);
            System.out.println("name :"+name);
           System.out.println("course:"+course);
           
       }
    }

     void semester(){
         class enrollement{
            int enrollement_id;
            int semester;
            int grade;

            void add_semester(){
                Scanner s=new Scanner(System.in);
                System.out.println("enter a enrollement id :");
                int enrollement_id= s.nextInt();
                System.out.println("enter a semester :");
                int semester=s.nextInt();
                System.out.println("enter a grade :");
                int grade=s.nextInt();
            }

            void display_enrollment(){
                System.out.println("enrollement id :"+enrollement_id);
                System.out.println("semester :"+semester);
                System.out.println("grade :"+grade);
            }
        }
        enrollement e= new enrollement();
        e.add_semester();
        System.out.println(e);
     }
    
    void scholarshoip(){
     new Object(){
        int marks;

    void check(){
        Scanner s=new Scanner(System.in);
        System.out.println("marks");
        int marks=s.nextInt(); 

        if(marks>=75){
           System.out.println("eligibal for scholarship.");
        }
        else{
            System.out.println("not eligibale for scholarship.");
        }
     }

     }.check();
 
    }
    public static void main(String[] args){
       Students s[] =new Students[3];
        Students.Course c[]= new Students.Course[3];
       for(int i=0;i<s.length;i++){
       
       s[i].student_data();
       
       c[i].add_Course();
       c[i].data();
        s[i].semester();
       s[i].scholarshoip();
       }
}
}
