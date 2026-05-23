// Custom exceptions
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class InputValidator {
    // Validate user input, throw vs throws
    public static void validateTransaction(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            // throw
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }
        if (amount > 100000) {
            // throw
            throw new InsufficientFundsException("Transaction exceeds maximum limit.");
        }
    }
}