package ui;

import exceptions.CustomerNotFoundException;
import exceptions.NameIsEmptyString;
import exceptions.NoBookIsFound;
import model.Book;
import model.Customer;
import model.NormalBook;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> availableBooks;
    private List<Customer> customerList;


    public Library() {
        this.availableBooks = new ArrayList();
        this.customerList = new ArrayList<>();


    }


    //MODIFIES: this
    //EFFECTS: add a book to the library unless it was already added

    public void addABook(String bookName, String authorName) throws NameIsEmptyString {
        try {
            findABook(bookName,authorName);
            System.out.println("this book is already in the library");
        } catch (NoBookIsFound noBookIsFound) {
            Book b = new NormalBook(bookName,authorName);
            availableBooks.add(b);
        }

    }


    public List<Book> getAvailableBooks() {
        return availableBooks;
    }


    public void setAvailableBooks(List<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }



    //REQUIRES: there are books in the library
    //MODIFIES: this
    //EFFECTS: print out a list of books
    public void getBooksNames() {
        for (Book b : availableBooks) {
            System.out.println("Book name: " + "<" + b.getName() + ">" + "\nAuthor's name: " + b.getAuthor());
        }
    }


    public Book findABook(String bookName, String authorName) throws NoBookIsFound {
        Book bookWanted = null;
        for (Book b : availableBooks) {
            if (b.getName().equals(bookName) && b.getAuthor().equals(authorName)) {
                bookWanted = b;
            }
        }

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

