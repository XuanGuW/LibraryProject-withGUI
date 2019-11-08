import exceptions.CustomerNotFoundException;
import model.Customer;
import model.Customers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomersTest {

    private Customers customers;
    private Customers customersNone;
    private Customer customer;

    @BeforeEach
    void runBefore() {
        customers = new Customers();
        customersNone = new Customers();
        customer = new Customer("name","123456");
        customers.getCustomers().put(customer.getName() + " " +customer.getPhoneNumber(),customer);

    }

    @Test
    void testSetCustomers(){
        customersNone.setCustomers(customers.getCustomers());
        assertEquals(customers.getCustomers(),customersNone.getCustomers());
    }

    @Test
    void testFindACustomer() {
        try {
            assertEquals(customer,customers.findACustomer(customer.getName(),customer.getPhoneNumber()));
        } catch (CustomerNotFoundException e) {
            fail();
        }

        try {
            customersNone.findACustomer(customer.getName(),customer.getPhoneNumber());
        } catch (CustomerNotFoundException e) {
            System.out.println("pass!");
        }


    }







}
