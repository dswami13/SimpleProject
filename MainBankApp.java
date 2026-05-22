import java.util.List;
import java.util.Optional;

public class MainBankApp {
    public static void main(String[] args) {
        System.out.println("Initializing Bank System");


        // Core Java and OOP
        BankAccount acc1 = new SavingsAccount("Dev_Swami_01", 1500.00);
        BankAccount acc2 = new SavingsAccount("Corp_Acc_99", 10000.00);


        System.out.println("\nTesting Core Logic");
        double originalPrincipal = 1000;
        BankCalculator.attemptToModifyPrincipal(originalPrincipal);
        System.out.println("Principal after pass-by-value test: " + originalPrincipal); // Should remain 1000
        System.out.println("Calculated 5yr Interest: $" + BankCalculator.calculateInterest(1000, 5, "savings"));
    }
}