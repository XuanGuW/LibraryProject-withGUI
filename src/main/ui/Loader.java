package ui;

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
            ArrayList<String> partsOfLine = splitOnSpace(string);
            NormalBook b = new NormalBook("name","author");
            b.setName(partsOfLine.get(0));
            b.setAuthor(partsOfLine.get(1));
            bookList.add(b);
            System.out.println(b.getName());
        }
        return bookList;

    }

    public static List<Customer> loadCustomer(List<Customer> customerList, String text) throws IOException {
        List<String> lineOfStrings = Files.readAllLines(Paths.get(text));

        for (String string : lineOfStrings) {
            ArrayList<String> partOfLine = splitOnSpace(string);
            Customer customer = new Customer("name","phoneNumber",null);
            customer.setName(partOfLine.get(0));
            customer.setPhoneNumber(partOfLine.get(1));


        }




        return customerList;

    }





    public static ArrayList<String> splitOnSpace(String line) {
        String[] splits = line.split(" ");
        return new ArrayList<>(Arrays.asList(splits));
    }
}