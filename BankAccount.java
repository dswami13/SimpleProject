import java.io.*;

// Abstraction (Interface)
interface BankOperations {
    void deposit(double amount);
    void withdraw(double amount) throws Exception;
}

// Classes & Objects , Basic serialization setup , Comparable
public abstract class BankAccount implements BankOperations, Serializable, Comparable<BankAccount> {
    // Encapsulation: private fields
    private String accountNumber;
    private double balance;

    // Constructors
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Encapsulation: getters/setters
    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Polymorphism: Method Overloading
    public void printDetails() {
        System.out.println("Account: " + accountNumber + " | Balance: $" + balance);
    }
    public void printDetails(boolean showPrefix) {
        if(showPrefix) {
            System.out.print("[BANK INFO] ");
        }
        printDetails();
    }

    @Override
    public int compareTo(BankAccount other) {
        // Natural sorting by balance
        return Double.compare(this.balance, other.balance);
    }
}

// Inheritance
class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    // Polymorphism: Method Overriding
    @Override
    public void withdraw(double amount) throws Exception {
        if (amount > getBalance()) {
            throw new Exception("Overdraft not allowed in Savings.");
        }
        setBalance(getBalance() - amount);
    }
}