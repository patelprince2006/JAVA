class BankAccount {
    private int balance = 1000; 

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName() + " deposited ₹" + amount + ". Balance: ₹" + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew ₹" + amount + ". Balance: ₹" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw ₹" + amount + " but insufficient balance.");
        }
    }
}

class DepositThread extends Thread {
    private BankAccount account;

    public DepositThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        account.deposit(500);
    }
}

class WithdrawThread extends Thread {
    private BankAccount account;

    public WithdrawThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        account.withdraw(700);
    }
}

public class BankSimulation {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread t1 = new DepositThread(account);
        Thread t2 = new WithdrawThread(account);
        Thread t3 = new WithdrawThread(account);
        Thread t4 = new DepositThread(account);

        t1.setName("Thread-Deposit-1");
        t2.setName("Thread-Withdraw-1");
        t3.setName("Thread-Withdraw-2");
        t4.setName("Thread-Deposit-2");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}