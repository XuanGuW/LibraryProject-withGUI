package main.ui;

import java.util.List;

public class Customer {
    String name;
    String phoneNumber;
    List<Book> myBooks;

    public Customer(String name, String phoneNumber, List<Book> myBooks) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.myBooks = myBooks;
    }

    //REQUIRES: the book is in the library
    //MODIFIES: book and this
    //EFFECTS: a customer borrow a book

    public void borrow(Book normalBook) {
        if (normalBook.getBorrower() == null) {
            normalBook.setAvailability(false);
            normalBook.setBorrower(this);
            myBooks.add(normalBook);
        } else {
            System.out.println("Sorry, this book is not available.");
        }
    }

    //REQUIRES: The book was lent out by the library
    //MODIFIES: book and this and book.getBorrower
    //EFFECTS: return a book to the library
    public void returnBook(Book normalBook) {
        if (normalBook.getBorrower() == this) {
            normalBook.setAvailability(true);
            normalBook.setBorrower(null);
            myBooks.remove(normalBook);


        }
    }


    public List<Book> getMyBooks() {
        return myBooks;
    }
}

