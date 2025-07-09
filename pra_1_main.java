import java.util.Scanner;
class pra_1_main{
     public static void main(String[] args){
        Employe[] e= new Employe[10];
         int countP=0;
        int countC=0;
        int totalobj=0;

        Object o[]=new Object[3];
        for(int i=0;i<o.length;i++){
        Scanner sc =new Scanner(System.in);
        System.out.print("enter id:");
        int id=sc.nextInt();
        System.out.print("enter name:");
        String Name=sc.next();
        System.out.print("enter department:");
        String department=sc.next();
        System.out.print("enter salary:");
        int salary=sc.nextInt();
         System.out.print("Enter Status (Permanent/Contract): ");
        String status=sc.next();
        
        e[i] = new Employe(id,Name,department,salary,status);
        System.out.println(e);
                    if(status.equalsIgnoreCase("Permanent")) 
            {
                countP++;
            } 
            else if(status.equalsIgnoreCase("Contract")) 
            {
                countC++;
            }
        }

        for(Employe emp:e) 
        {  
            emp.display(); 
            totalobj++;   
        }
        System.out.println("Number of Permanent Employees: " + countP);
        System.out.println("Number of Contract Employees : " + countC);
        System.out.println("Number of Total Employees : " + totalobj);

        }
}