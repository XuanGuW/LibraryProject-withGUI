package main.ui;

import java.util.ArrayList;
import java.util.List;

public class Library {
    List<Book> availablebook;
    int size;

    public Library() {
        this.availablebook = new ArrayList();
        this.size = 0;

    }

    



    //MODIFIES: this
    //EFFECTS: add a book to the library unless it was already added, in which case do nothing
    public void addABook(Book book) {
        if (!availablebook.contains(book)) {
            availablebook.add(book);
        }
    }



    //REQUIRES: there are books in the library
    //MODIFIES: this
    //EFFECTS: print out a list of books

    public void getBooks() {
        for (Book b : availablebook) {
            System.out.println("Book name: " + "<" + b.name + ">" + "\nAuthor's name: " + b.author);
        }
    }


    //EFFECTS: check if the library contains the book

    public boolean contains(Book book) {
        return availablebook.contains(book);
    }

    //EFFECTS: return the size of the library

    public int librarySize() {
        return availablebook.size();
    }




}

