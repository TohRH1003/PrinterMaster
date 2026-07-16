package PrintMaster;

/**
 * Represents a customer with personal information and customer type.
 * Customer type is used for discount eligibility.
 */
public class Customer {
    private String customerId;
    private String name;
    private String email;
    private String phone;
    private String customerType; // e.g., "Student", "Corporate", "Regular"

    public Customer() {
    }

    public Customer(String customerId, String name, String email, String phone, String customerType) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.customerType = customerType;
    }

    // Getters and Setters
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", customerType='" + customerType + '\'' +
                '}';
    }
}
