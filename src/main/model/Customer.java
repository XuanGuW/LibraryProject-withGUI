package model;

import java.util.List;
import java.util.Map;

public class Customer {
    private String name;
    private String phoneNumber;
    private Map<String, Book> myBooks;

    public Customer(String name, String phoneNumber, Map<String, Book> myBooks) {


        this.name = name;
        this.phoneNumber = phoneNumber;
        this.myBooks = myBooks;
    }

    //REQUIRES: the book is in the library
    //MODIFIES: book and this
    //EFFECTS: a customer borrow a book
    public void borrow(Book book) {

        if (book.getBorrower() == null) {
            book.setAvailability(false);
            book.setBorrower(this);
            myBooks.put(book.getName(),book);
        } else {
            System.out.println("Sorry, this book is not available right now.");
        }
    }

    //REQUIRES: The book was lent out by the library
    //MODIFIES: book and this and book.getBorrower
    //EFFECTS: return a book to the library
    public void returnBook(Book book) {
        if (book.getBorrower().getName().equals(name) && book.getBorrower().getPhoneNumber().equals(phoneNumber)) {
            book.setAvailability(true);
            book.setBorrower(null);
            myBooks.remove(book.getName());


        }
    }


    public String toString() {
        return (name + " " + phoneNumber);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMyBooks(Map<String, Book> books) {
        this.myBooks = books;
    }


    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Map<String, Book> getMyBooks() {
        return myBooks;
    }
}

