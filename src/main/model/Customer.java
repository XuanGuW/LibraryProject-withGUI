package model;


import java.util.*;

public class Customer implements Observer {
    private String name;
    private String phoneNumber;
    private Map<String, Book> myBooks;

    public Customer(String name, String phoneNumber) {

        this.name = name;
        this.phoneNumber = phoneNumber;
        this.myBooks = new HashMap<>();
    }

    //REQUIRES: the book is in the library
    //MODIFIES: book and this
    //EFFECTS: a customer borrow a book
    public void borrow(Book book) {
        if (book.getBorrower() == null) {

            book.setCustomer(this);
            myBooks.put(book.getName(),book);
        } else {
            System.out.println("Sorry, this book is not available right now.");
        }
    }

    //REQUIRES: The book was lent out by the library
    //MODIFIES: book and this and book.getBorrower
    //EFFECTS: return a book to the library
    public void returnBook(Book book) {

        if (book.getBorrower().getName().equals(name)) {


            book.setCustomer(null);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) o;
        return name.equals(customer.name)
                && phoneNumber.equals(customer.phoneNumber)
                && Objects.equals(myBooks, customer.myBooks);
    }



    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber, myBooks);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Hello, " + name + "A new book: " + arg + " is added to the library!");
    }


}

