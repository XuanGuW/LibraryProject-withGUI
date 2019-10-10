package main.ui;



public class NormalBook extends AbstractBook {

    private String name;
    private String author;
    private Customer borrower;
    private Boolean availability;


    public NormalBook(String name, String author) {
        this.name = name;
        this.author = author;
        this.borrower = null;
        this.availability = true;
    }





}
