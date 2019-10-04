package main.ui;

import java.io.Serializable;

public class Book {

    String name;
    String author;
    Customer borrower;
    Boolean availability;


    public Book(String name,String author) {
        this.name = name;
        this.author = author;
        this.borrower = null;
        this.availability = true;
    }

    //EFFECTS: return the availability
    public boolean isAvailable() {
        return availability;
    }

    //EFFECTS: A customer borrow a book
    public Customer getBorrower() {
        return borrower;
    }

    //EFFECT: Make two strings to represent book name and author
    @Override//not knowing why it is override
    public String toString() {
        return "Name: " + name + "\nAuthor: " + author;
    }

}
