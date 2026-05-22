public class BankCalculator {
    // Methods, parameters, and return types
    public static double calculateInterest(double principal, int years, String accountType) {
        // Variables & scope, Data types (primitive double/int, reference String)
        double rate = 0.0;

        // Switch statement
        switch (accountType.toLowerCase()) {
            case "savings": rate = 0.04;
                break;
            case "fixed": rate = 0.07;
                break;
            default: rate = 0.01;
        }

        // Operators
        double totalInterest = 0;

        // For loop
        for (int i = 1; i <= years; i++) {
            totalInterest += (principal * rate);
        }

        // While and do-while loops
        int counter = 0;
        while(counter < 1) {
            counter++;
        }
        do {
            counter--;
        }
        while(counter > 0);

        return totalInterest;
    }

    // Pass by value concept
    public static void attemptToModifyPrincipal(double principalCopy) {
        principalCopy = principalCopy - 100;
    }
}
