package ui;

import model.Book;
import model.Customer;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class Saver {


    public static void saveBooks(Map<String, Book> normalBookList, String text) throws IOException {

        PrintWriter writer = new PrintWriter(text);
        writer.println(normalBookList.keySet());
        writer.close();

    }

    public static void saveCustomers(Map<String, Customer> customers, String text) throws IOException {

        PrintWriter writer = new PrintWriter(text);
        writer.println(customers.keySet());
        writer.close();
    }


    //may do later
    public static void saveCustomer(Customer customer) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(customer.getName() + ".txt");


    }



}