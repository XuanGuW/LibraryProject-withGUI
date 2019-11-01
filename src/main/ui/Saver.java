package ui;

import model.Book;
import model.Customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class Saver {


    public static void save(Map<String, Book> normalBookList, String text) throws IOException {

        PrintWriter writer = new PrintWriter("booksNew.txt","UTF-8");


        writer.println(normalBookList.keySet());

        writer.close();
    }

    public static void save(List<Customer> customers) throws IOException {
        PrintWriter writer = new PrintWriter("customersNew.txt");

        for (Customer customer : customers) {
            writer.println(customer.toString());

        }
        writer.close();
    }
}