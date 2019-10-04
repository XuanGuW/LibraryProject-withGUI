package main.ui;

import java.util.List;

public class Customer {
    String name;
    Integer phoneNumber;
    List<NormalBook> myNormalBooks;

    public Customer(String name, Integer phoneNumber, List<NormalBook> myNormalBooks) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.myNormalBooks = myNormalBooks;
    }

    //REQUIRES: the book is in the library
    //MODIFIES: book and this
    //EFFECTS: a customer borrow a book

    public void borrow(NormalBook normalBook) {
        if (normalBook.getBorrower() == null) {
            normalBook.availability = false;
            normalBook.borrower = this;
            myNormalBooks.add(normalBook);
        } else {
            System.out.println("Sorry, this book is not available.");
        }
    }

    //REQUIRES: The book was lent out by the library
    //MODIFIES: book and this and book.getBorrower
    //EFFECTS: return a book to the library
    public void returnBook(NormalBook normalBook) {
        if (normalBook.borrower == this) {
            normalBook.availability = true;
            normalBook.borrower = null;
            myNormalBooks.remove(normalBook);


        }
    }


    public List<NormalBook> getMyNormalBooks() {
        return myNormalBooks;
    }
}

