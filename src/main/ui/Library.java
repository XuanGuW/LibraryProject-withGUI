package ui;

import exceptions.CustomerNotFoundException;
import exceptions.NoBookIsFound;
import model.Book;
import model.Customer;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> availableBooksList;
    private List<Customer> customerList;
    int size;

    public Library() {
        this.availableBooksList = new ArrayList();
        this.customerList = new ArrayList<>();
        this.size = 0;

    }


    //MODIFIES: this
    //EFFECTS: add a book to the library unless it was already added, in which case do nothing

    public void addABook(Book book) {
        if (!availableBooksList.contains(book)) {
            availableBooksList.add(book);
        }
    }


    public List<Book> getAvailableBooksList() {
        return availableBooksList;
    }


    public void setAvailableBooksList(List<Book> availableBooksList) {
        this.availableBooksList = availableBooksList;
    }



    //REQUIRES: there are books in the library
    //MODIFIES: this
    //EFFECTS: print out a list of books

    public void getBooksNames() {
        for (Book b : availableBooksList) {
            System.out.println("Book name: " + "<" + b.getName() + ">" + "\nAuthor's name: " + b.getAuthor());
        }
    }


    //EFFECTS: check if the library contains the book

    public boolean contains(Book book) {
        return availableBooksList.contains(book);
    }


    //EFFECTS: return the number of books
    public int booksNumber() {
        return availableBooksList.size();
    }



    public Book findABook(String bookName, String authorName) throws NoBookIsFound {
        Book bookWanted = null;
        for (Book b : availableBooksList) {
            if (b.getName() == bookName && b.getAuthor() == authorName) {
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
            if (customer.getName() == customerName && customer.getPhoneNumber() == phoneNumber) {
                customerWanted = customer;
            }
        }

        if (customerWanted == null) {
            throw new CustomerNotFoundException();
        }
        return customerWanted;
    }




}

