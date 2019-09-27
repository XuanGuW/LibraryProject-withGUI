package main.ui;

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

    //MODIFIES: this
    //EFFECTS: return the availability
    public boolean isAvailable() {
        return availability;
    }



    //MODIFIES: this and customer
    //EFFECTS: A customer borrow a book
    public Customer getBorrower() {
        return borrower;
    }
}
