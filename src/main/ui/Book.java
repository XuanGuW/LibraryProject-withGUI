package main.ui;

public interface Book {


    //EFFECTS: get the author
    public String getAuthor();


    //EFFECTS: get the name of book
    public String getName();


    //EFFECTS: set name
    public void setName(String name);

    //EFFECTS: set author
    public void setAuthor(String author);


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
