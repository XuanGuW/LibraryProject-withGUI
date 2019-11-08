package model;

import exceptions.CustomerNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class Customers {
    private Map<String, Customer> customers;


    public Customers() {
        this.customers = new HashMap<>();

    }


    public Map<String, Customer> getCustomers() {
        return customers;
    }


    //EFFECTS: find the customer with this name
    public Customer findACustomer(String customerName, String phoneNumber) throws CustomerNotFoundException {

        Customer customerWanted = customers.get(customerName + " " + phoneNumber);
        if (customerWanted == null) {
            throw new CustomerNotFoundException();
        }
        return customerWanted;
    }

    public void setCustomers(Map<String, Customer> customers) {
        this.customers = customers;

    }
}
