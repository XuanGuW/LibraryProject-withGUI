package ui;

import model.Book;
import model.Customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class Saver {


    public static void saveBook(Map<String, Book> normalBookList, String text) throws IOException {

        PrintWriter writer = new PrintWriter(text);
        writer.println(normalBookList.keySet());
        writer.close();

    }

    public static void saveCustomer(Map<String, Customer> customers, String text) throws IOException {

        PrintWriter writer = new PrintWriter(text);
        writer.println(customers.keySet());
        writer.close();

    }
}