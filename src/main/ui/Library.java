package ui;

import exceptions.CustomerNotFoundException;
import exceptions.NameIsEmptyString;
import exceptions.NoBookIsFound;
import model.Book;
import model.Customer;
import model.NormalBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<String, Book> libraryBooks;
    private Map<String, Customer> libraryCustomers;



    private List<Customer> customerList;


    public Library() {
        this.libraryBooks = new HashMap<>();
        this.libraryCustomers = new HashMap<>();


        this.customerList = new ArrayList<>();



    }

    public Map<String, Book> getLibraryBooks() {
        return libraryBooks;
    }

    public void setLibraryBooks(Map<String, Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }


    //MODIFIES: this
    //EFFECTS: add a book to the library unless it was already added

    public void addABook(String bookName, String authorName) throws NameIsEmptyString {
        try {
            findABook(bookName,authorName);
            System.out.println("this book is already in the library");
        } catch (NoBookIsFound noBookIsFound) {
            Book b = new NormalBook(bookName,authorName);
            libraryBooks.put(bookName,b);
        }

    }


    //REQUIRES: there are books in the library
    //MODIFIES: this
    //EFFECTS: print out a list of books
    public void getBooksNames() {
        System.out.println(libraryBooks.keySet());
    }


    public Book findABook(String bookName, String authorName) throws NoBookIsFound {
        Book bookWanted = libraryBooks.get(bookName);


        if (bookWanted == null) {
            throw new NoBookIsFound();
        }
        return bookWanted;
    }


    //EFFECTS: find the customer with this name
    public Customer findACustomer(String customerName, String phoneNumber) throws CustomerNotFoundException {

        Customer customerWanted = null;
        for (Customer customer : customerList) {
            if (customer.getName().equals(customerName) && customer.getPhoneNumber().equals(phoneNumber)) {
                customerWanted = customer;
            }
        }

        if (customerWanted == null) {
            throw new CustomerNotFoundException();
        }
        return customerWanted;
    }




}

