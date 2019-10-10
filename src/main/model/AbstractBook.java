package model;

public abstract class AbstractBook implements Book {

    protected String name;
    protected String author;
    protected Customer borrower;
    protected Boolean availability = true;

    //EFFECT: Make two strings to represent book name and author
    @Override
    public String toString() {
        return  name + " " + author;
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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAuthor() {
        return author;
    }


    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void setBorrower(Customer customer) {
        this.borrower = customer;
    }

    @Override
    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

}
