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

    //SPECIFIES: return true if a book is available or false otherwise

    public boolean isAvailable() {
        return availability;
    }





    public Customer getBorrower() {
        return borrower;
    }
}
