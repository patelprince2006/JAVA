
public class student{
    int rollno;
    String name;
    int Sub_1;
    int Sub_2;
    int Sub_3;

      public student(int rollno, String name, int Sub_1, int Sub_2, int Sub_3) {
        this.rollno = rollno;
        this.name = name;
        this.Sub_1 = Sub_1;
        this.Sub_2 = Sub_2;
        this.Sub_3 = Sub_3;
    }
       public void display(){
        System.out.println("Roll No: " + rollno);
        System.out.println("Name: " + name);
        System.out.println("Sub 1: " + Sub_3);
        System.out.println("Sub 2: " + Sub_2);
        System.out.println("Sub 3: " + Sub_1);

        if(Sub_1>38 && Sub_2>38 && Sub_3>38){
            System.out.println("pass");
        }
    }
    public String toString() {
        return "Roll No: " + rollno + "\nName: " + name +
               "\nSub 1: " + Sub_1 + "\nSub 2: " + Sub_2 + "\nSub 3: " + Sub_3;
    }
}
