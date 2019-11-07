package model;

public interface Book {

    //EFFECT: Make two strings to represent book name and author
    String toString();

    //EFFECTS: get the author
    String getAuthor();

    //EFFECTS: get the name of book
    String getName();

    //EFFECTS: set name
    void setName(String name);

    //EFFECTS: set author
    void setAuthor(String author);

    //EFFECTS: return the availability
    boolean isAvailable();

    //EFFECTS: A customer borrow a book
    Customer getBorrower();

    //EFFECT: a customer borrows a book
    void borrowing(Customer customer);

    //EFFECT: set the availability
    void setAvailability(Boolean availability);

    //EFFECTS: set the borrower
    void setBorrower(Customer customer);



}
