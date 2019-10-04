package main.ui;

import java.util.List;

public class Customer {
    String name;
    Integer phoneNumber;
    List<Book> myBooks;



    public Customer(String name, Integer phoneNumber, List<Book> myBooks) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.myBooks = myBooks;
    }

    //REQUIRES: the book is in the library
    //MODIFIES: book and this
    //EFFECTS: a customer borrow a book

    public void borrow(Book book) {
        if (book.getBorrower() == null) {
            book.availability = false;
            book.borrower = this;
            myBooks.add(book);
        } else {
            System.out.println("Sorry, this book is not available.");
        }
    }

    //REQUIRES: The book was lent out by the library
    //MODIFIES: book and this and book.getBorrower
    //EFFECTS: return a book to the library
    public void returnBook(Book book) {
        if (book.borrower == this) {
            book.availability = true;
            book.borrower = null;
            myBooks.remove(book);


        }
    }


    public List<Book> getMyBooks() {
        return myBooks;
    }
}

