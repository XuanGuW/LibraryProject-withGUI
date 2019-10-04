package main.ui;

import java.util.ArrayList;
import java.util.List;

public class Library implements Books {
    public List<NormalBook> availableNormalBooks;
    int size;

    public Library() {
        this.availableNormalBooks = new ArrayList();
        this.size = 0;

    }


    //MODIFIES: this
    //EFFECTS: add a book to the library unless it was already added, in which case do nothing
    @Override
    public void addABook(NormalBook normalBook) {
        if (!availableNormalBooks.contains(normalBook)) {
            availableNormalBooks.add(normalBook);
        }
    }



    //REQUIRES: there are books in the library
    //MODIFIES: this
    //EFFECTS: print out a list of books
    @Override
    public void getBooks() {
        for (NormalBook b : availableNormalBooks) {
            System.out.println("Book name: " + "<" + b.name + ">" + "\nAuthor's name: " + b.author);
        }
    }


    //EFFECTS: check if the library contains the book
    @Override
    public boolean contains(NormalBook normalBook) {
        return availableNormalBooks.contains(normalBook);
    }


    //EFFECTS: return the number of books
    @Override
    public int booksNumber() {
        return availableNormalBooks.size();
    }




}

