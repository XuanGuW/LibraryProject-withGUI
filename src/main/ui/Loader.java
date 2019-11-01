package ui;

import exceptions.NameIsEmptyString;
import model.Book;
import model.Customer;
import model.NormalBook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Loader {


    public static List<Book> load(List<Book> bookList, String text) throws IOException {
        List<String> lineOfStrings = Files.readAllLines(Paths.get(text));
        for (String string : lineOfStrings) {
            try {
                ArrayList<String> partsOfLine = splitOnSpace(string);
                Book b = new NormalBook("name","author");
                b.setName(partsOfLine.get(0));
                b.setAuthor(partsOfLine.get(1));
                bookList.add(b);
            } catch (NameIsEmptyString emptyString) {
                System.out.println("Book name should not be empty");
            }
        }
        return bookList;

    }

    public static List<Customer> loadCustomers(String text) throws IOException {
        List<String> lineOfStrings = Files.readAllLines(Paths.get(text));
        List<Customer> customerList = new ArrayList<>();
        for (String string : lineOfStrings) {
            ArrayList<String> partOfLine = splitOnSpace(string);
            Customer customer = new Customer("name","phoneNumber",null);
            customer.setName(partOfLine.get(0));
            customer.setPhoneNumber(partOfLine.get(1));
            customerList.add(customer);
        }
        return customerList;

    }


    public static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }
}