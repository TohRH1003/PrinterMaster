package PrintMaster;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Reads customer information from customer.txt based on customer ID.
 * Returns a Customer object if found; null otherwise.
 */
public class ReadCustomer {
    private static final String FILE_PATH = "customer.txt";

    public Customer getCustomer(String customerId) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty())
                    continue;
                String[] parts = line.split(",");
                if (parts.length == 5 && parts[0].trim().equals(customerId)) {
                    return new Customer(
                            parts[0].trim(),
                            parts[1].trim(),
                            parts[2].trim(),
                            parts[3].trim(),
                            parts[4].trim());
                }
            }
        }
        return null; // not found or file missing
    }
}