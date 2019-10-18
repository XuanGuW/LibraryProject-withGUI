package model;

public interface Book {


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


    //EFFECT: Make two strings to represent book name and author
    String toString();


    //EFFECT: set the borrower
    public void setBorrower(Customer customer);

    //EFFECT: set the availability
    public void setAvailability(Boolean availability);
}
