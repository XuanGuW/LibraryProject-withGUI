package main.ui;

import java.io.Serializable;

public class NormalBook implements Book {

    public String name;
    public String author;
    public Customer borrower;
    public Boolean availability;


    public NormalBook(String name, String author) {
        this.name = name;
        this.author = author;
        this.borrower = null;
        this.availability = true;
    }

    //EFFECTS: return the availability
    @Override
    public boolean isAvailable() {
        return availability;
    }

    //EFFECTS: A customer borrow a book
    @Override
    public Customer getBorrower() {
        return borrower;
    }

    //EFFECT: Make two strings to represent book name and author
    @Override
    public String toString() {
        return  name + " " + author;
    }

}
