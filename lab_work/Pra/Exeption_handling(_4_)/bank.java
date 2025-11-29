		import java.util.Scanner; 
 class InvalidTransactionException extends Exception {     public InvalidTransactionException(String message) {         super(message); 
    } } class InsufficientFundsException extends RuntimeException {     public InsufficientFundsException(String message) {         super(message); 
    } } class BankAccount { 
    private double balance; 
     public BankAccount() {         this.balance = 0; 
    }  
    public void deposit(double amount) throws InvalidTransactionException {         if (amount <= 0) {             throw new InvalidTransactionException("Deposit amount must be positive.");         } 
        balance += amount; 
        System.out.println("Deposited: " + amount + ", New Balance: " + balance); 
    } 
 	

		    public void withdraw(double amount)throws 
InvalidTransactionException, InsufficientFundsException {         if (amount <= 0) {             throw new InvalidTransactionException("Withdrawal amount must be positive."); 
        }         if (amount > balance) {             throw new InsufficientFundsException("Insufficient funds for withdrawal."); 
        } 
        balance -= amount; 
        System.out.println("Withdrew: " + amount + ", New Balance: " + balance); 
    }      public double getBalance() {         return balance;  
    } } public class bank { 
    public static void main(String[] args) { 
        BankAccount account = new BankAccount(); 
        Scanner sc = new Scanner(System.in); 
         try { 
            while (true) { 
                System.out.println("Choose operation: 1 for Deposit, 2 for Withdrawal,0 fro exit");                 int choice = sc.nextInt();                 switch (choice) {                     case 1: 
                        System.out.print("Enter deposit amount: ");                         double dep = sc.nextDouble();                         account.deposit(dep);                         break;                     case 2: 
                        System.out.print("Enter withdrawal amount: ");                         double wd = sc.nextDouble();                         account.withdraw(wd);                         break; 
                     case 0:
                        { 
                        System.out.println("Exiting..."); 
                        }    
                                         default: 	
		                        System.out.println("Invalid choice."); 
                } 
            } 
        } catch (InvalidTransactionException e) { 
            System.out.println("Transaction Error: " + e.getMessage()); 
        } catch (InsufficientFundsException e) { 
            System.out.println("Funds Error: " + e.getMessage()); 
        } finally { 
            System.out.println("Final Balance: " + account.getBalance());             sc.close(); 
        } 
        System.out.println("\n24CE092-Prince Patel "); 
    } 
} 
 
 	
