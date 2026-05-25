import java.util.*;
import java.util.stream.Collectors;

public class AccountAnalytics {

    // Functional interface use
    public static void processAccounts(List<BankAccount> accounts) {
        // Streams API , Lambda expressions
        // Filtering, mapping, grouping , Replacing loops with streams

        System.out.println("Rich Clients (Balance > 5000)");
        accounts.stream()
                .filter(acc -> acc.getBalance() > 5000) // Filtering
                .map(BankAccount::getAccountNumber)     // Mapping
                .forEach(System.out::println);          // Output

        // Grouping
        Map<String, List<BankAccount>> grouped = accounts.stream()
                .collect(Collectors.groupingBy(acc -> acc.getBalance() > 5000 ? "High" : "Standard"));
        System.out.println("Grouped Account Types: " + grouped.keySet());
    }

    // Optional
    public static Optional<BankAccount> findAccount(List<BankAccount> accounts, String targetId) {
        return accounts.stream()
                .filter(a -> a.getAccountNumber().equals(targetId))
                .findFirst();
    }
}
