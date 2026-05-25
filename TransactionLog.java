import java.io.*;

public class TransactionLog {
    private static final String FILE_NAME = "audit.txt";

    // Reading/writing files
    public static void writeLog(String message) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(message);
            bw.newLine();
        }
        catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }

    // BufferedReader / FileReader
    public static void readLogs() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("LOG: " + line);
            }
        }
        catch (IOException e) {
            System.out.println("Log file not found or empty.");
        }
    }

    // Basic serialization
    public static void serializeAccount(BankAccount acc) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("acc.ser"))) {
            oos.writeObject(acc);
            System.out.println("Account serialized successfully.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
