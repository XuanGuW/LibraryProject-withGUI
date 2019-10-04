package main.ui;

public interface Book {
    //EFFECTS: return the availability
    boolean isAvailable();

    //EFFECTS: A customer borrow a book
    Customer getBorrower();


    //EFFECT: Make two strings to represent book name and author
    String toString();
}
