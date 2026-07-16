package PrintMaster;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CustomerTest {

    @Test
    public void customerConstructorTest(){
        Customer customer = new Customer("C001", "John Cena", "johncena@gmail.com", "0123456789", "Student");
        assertEquals("C001", customer.getCustomerId());
        assertEquals("John Cena", customer.getName());
        assertEquals("johncena@gmail.com", customer.getEmail());
        assertEquals("0123456789", customer.getPhone());
        assertEquals("Student", customer.getCustomerType());
    }

    @Test
    public void customerIdSetterTest(){
        Customer customer = new Customer();

        customer.setCustomerId("C10");
        assertEquals("C10", customer.getCustomerId());
    }

    @Test
    public void nameSetterTest(){
        Customer customer = new Customer();

        customer.setName("The Rock");
        assertEquals("The Rock", customer.getName());
    }

    @Test
    public void emailSetterTest(){
        Customer customer = new Customer();

        customer.setEmail("therock@gmail.com");
        assertEquals("therock@gmail.com", customer.getEmail());
    }

    @Test
    public void phoneSetterTest(){
        Customer customer = new Customer();

        customer.setPhone("0987654321");
        assertEquals("0987654321", customer.getPhone());
    }

    @Test
    public void customerTypeSetterTest(){
        Customer customer = new Customer();

        customer.setCustomerType("Corporate");
        assertEquals("Corporate", customer.getCustomerType());
    }
}
