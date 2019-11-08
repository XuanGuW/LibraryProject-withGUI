package model;

import exceptions.BookAlreadyExistException;
import exceptions.CustomerNotFoundException;
import exceptions.NameIsEmptyString;
import exceptions.NoBookIsFound;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static sun.tools.jstat.Alignment.keySet;

public class Library {
    private Map<String, Book> libraryBooks;
    private Map<String, Customer> libraryCustomers;


    public Library() {
        this.libraryBooks = new HashMap<>();
        this.libraryCustomers = new HashMap<>();
    }

    public Map<String, Book> getLibraryBooks() {
        return libraryBooks;
    }

    public Map<String, Customer> getLibraryCustomers() {
        return libraryCustomers;
    }

    public void setLibraryBooks(Map<String, Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public void setLibraryCustomers(Map<String, Customer> libraryCustomers) {
        this.libraryCustomers = libraryCustomers;

    }

    //MODIFIES: this
    //EFFECTS: print out a list of books
    public Set<String> getBooksNames() {
        return libraryBooks.keySet();
    }

    public Book findABook(String bookName, String authorName) throws NoBookIsFound {
        Book bookWanted = libraryBooks.get(bookName + " " + authorName);
        if (bookWanted == null) {
            throw new NoBookIsFound();
        }
        return bookWanted;
    }

    //EFFECTS: find the customer with this name
    public Customer findACustomer(String customerName, String phoneNumber) throws CustomerNotFoundException {

        Customer customerWanted = libraryCustomers.get(customerName + " " + phoneNumber);
        if (customerWanted == null) {
            throw new CustomerNotFoundException();
        }
        return customerWanted;
    }

}

