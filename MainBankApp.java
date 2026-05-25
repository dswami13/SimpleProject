import java.util.List;
import java.util.Optional;

public class MainBankApp {
    public static void main(String[] args) {
        System.out.println("Initializing Bank System");

        // Collections Framework
        CustomerDatabase db = new CustomerDatabase();

        // Core Java and OOP
        BankAccount acc1 = new SavingsAccount("Dev_Swami_01", 1500.00);
        BankAccount acc2 = new SavingsAccount("Corp_Acc_99", 10000.00);

        db.addAccount(acc1);
        db.addAccount(acc2);

        System.out.println("\nTesting Core Logic");
        double originalPrincipal = 1000;
        BankCalculator.attemptToModifyPrincipal(originalPrincipal);

        System.out.println("Principal after pass-by-value test: " + originalPrincipal); // Should remain 1000
        System.out.println("Calculated 5yr Interest: $" + BankCalculator.calculateInterest(1000, 5, "savings"));

        // Exception Handling (try-catch-finally)
        System.out.println("\nTesting Exception Handling Logic");
        try {
            InputValidator.validateTransaction(-50); // Throws exception
            acc1.withdraw(5000);
        }
        catch (InsufficientFundsException | IllegalArgumentException e) {
            System.out.println("Transaction Failed: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
        }
        finally {
            System.out.println("Transaction attempted");
            TransactionLog.writeLog("Attempted transaction on " + acc1.getAccountNumber());
        }

        System.out.println("\nTesting Java 8 Streams");
        List<BankAccount> allAccounts = db.getAllAccounts();
        AccountAnalytics.processAccounts(allAccounts);

        Optional<BankAccount> search = AccountAnalytics.findAccount(allAccounts, "Dev_Swami_01");
        search.ifPresent(account -> System.out.println("Found Account: " + account.getAccountNumber()));

        System.out.println("\nTesting IO and Collections Sorting");
        db.printAccountsSorted(); // Sorts using Comparator
        TransactionLog.serializeAccount(acc1);
        TransactionLog.readLogs();
    }
}