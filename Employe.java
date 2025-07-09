
class Employe{
     private int id;
     private String Name;
     private String department;
     private int salary;
     private String status;

// public int getID(){
//     return id;
// }

//  public void setID(int id){
//     this.id=id;
// }

// public void setName(String Name){
//     this.Name=Name;
// }

// public String getName(){
//     return Name;
// }

// public String getdepartment(){
//      return department;
// }

// public void setdepartment(String department){
//     this.department=department;
// }

// public int getsalary(){
//     return salary;
// }

// public void setsalary(){
//     this.salary = salary;
// }

  public Employe(int id,String Name,String department,int salary,String status){
     this.id=id;
     this.Name=Name;
     this.department=department;
     this.salary=salary;
     this.status=status;
  }
   void display() 
    {
        System.out.println("ID : " +id);
        System.out.println("Name : " +Name);
        System.out.println("Department: " +department);
        System.out.println("Salary : " +salary);
        System.out.println("Status : " +status);
    }
  public Employe(){};
}
   