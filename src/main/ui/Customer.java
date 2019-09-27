package main.ui;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    String name;
    Integer phonenumber;


    //this will get customer to see what they have borrowed, and will be down later
    List<Book> mybooks = new ArrayList<>();



    public Customer(String name, Integer phonenumber) {
        this.name = name;
        this.phonenumber = phonenumber;
    }

    //REQUIRES: the book is not borrowed by others
    //MODIFIES: book and this
    //EFFECTS: a customer borrow a book

    public void borrow(Book book) {
        if (book.getBorrower() == null) {
            book.availability = false;
            book.borrower = this;
            mybooks.add(book);
        }
    }

    //REQUIRES: The book was lent out by the library
    //MODIFIES: book and this and book.getBorrower
    //EFFECTS: return a book to the library
    public void returnBook(Book book) {
        if (book.borrower == this) {
            book.availability = true;
            book.borrower = null;
            mybooks.remove(book);


        }
    }


}

