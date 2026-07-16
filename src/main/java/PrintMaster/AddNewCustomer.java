package PrintMaster;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Adds a new customer to customer.txt. Checks for duplicate customer ID.
 */
public class AddNewCustomer {
    private static final String FILE_PATH = "customer.txt";

    public void addCustomer(Customer customer) throws IOException, IllegalArgumentException {
        if (customerExists(customer.getCustomerId())) {
            throw new IllegalArgumentException("Customer ID " + customer.getCustomerId() + " already exists.");
        }

        File file = new File(FILE_PATH);
        file.getParentFile().mkdirs(); // ensure parent directories exist

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            String record = String.format("%s,%s,%s,%s,%s%n",
                    customer.getCustomerId(),
                    customer.getName(),
                    customer.getEmail(),
                    customer.getPhone(),
                    customer.getCustomerType());
            writer.write(record);
        }
    }

    private boolean customerExists(String customerId) throws IOException {
        ReadCustomer reader = new ReadCustomer();
        return reader.getCustomer(customerId) != null;
    }
}
