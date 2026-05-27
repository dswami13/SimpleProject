import java.util.*;

public class CustomerDatabase {
    // Map (HashMap)
    private HashMap<String, BankAccount> accountMap = new HashMap<>();
    // Set (HashSet)
    private HashSet<String> activeUsers = new HashSet<>();
    // List (LinkedList)
    private LinkedList<String> transactionHistory = new LinkedList<>();

    public void addAccount(BankAccount acc) {
        accountMap.put(acc.getAccountNumber(), acc);
        activeUsers.add(acc.getAccountNumber());
    }

    // List (ArrayList)
    public ArrayList<BankAccount> getAllAccounts() {
        return new ArrayList<>(accountMap.values());
    }

    public void printAccountsSorted() {
        List<BankAccount> list = getAllAccounts();

        // Comparable vs Comparator
        // Using an anonymous Comparator to sort by account number descending
        list.sort(new Comparator<BankAccount>() {
            @Override
            public int compare(BankAccount acc1, BankAccount acc2) {
                return acc2.getAccountNumber().compareTo(acc1.getAccountNumber());
            }
        });

        // Iteration techniques
        Iterator<BankAccount> it = list.iterator();
        while (it.hasNext()) {
            BankAccount acc = it.next();
            acc.printDetails();
        }
    }
}
