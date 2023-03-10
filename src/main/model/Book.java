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

    //EFFECTS: A customer borrow a book
    Customer getBorrower();

    //EFFECT: a customer borrows a book
    void setCustomer(Customer customer);



}
