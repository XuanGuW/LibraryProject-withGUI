package model;

import java.util.List;

public interface Books {
    //MODIFIES: this
    //EFFECTS: add a book to the library unless it was already added, in which case do nothing
    void addABook(Book normalBook);

    //REQUIRES: there are books in the books
    //MODIFIES: this
    //EFFECTS: print out a list of books
    public void getBooksNames();


    //EFFECTS: check if there is any book
    boolean contains(Book normalBook);

    //EFFECTS: get a list of books objects
    List<Book> getAvailableBooksList();


    //EFFECTS: set the books
    void setAvailableBooksList(List<Book> availableNormalBooksList);

    //EFFECTS: return the number of books
    int booksNumber();
}
