package main.ui;

public interface Books {
    //MODIFIES: this
    //EFFECTS: add a book to the library unless it was already added, in which case do nothing
    void addABook(NormalBook normalBook);

    //REQUIRES: there are books in the books
    //MODIFIES: this
    //EFFECTS: print out a list of books
    void getBooks();


    //EFFECTS: check if there is any book
    boolean contains(NormalBook normalBook);



    //EFFECTS: return the number of books
    int booksNumber();
}
