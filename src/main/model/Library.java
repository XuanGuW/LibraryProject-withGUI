package model;



import exceptions.NoBookIsFound;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Library {
    private Map<String, Book> libraryBooks;


    public Library() {
        this.libraryBooks = new HashMap<>();

    }



    public Map<String, Book> getLibraryBooks() {
        return libraryBooks;
    }

    //MODIFIES: this
    //EFFECTS: print out a list of books
    public Set<String> getBooksNames() {
        return libraryBooks.keySet();
    }

    public void setLibraryBooks(Map<String, Book> libraryBooks) {
        this.libraryBooks = libraryBooks;
    }

    public Book findABook(String bookName, String authorName) throws NoBookIsFound {
        Book bookWanted = libraryBooks.get(bookName + " " + authorName);
        if (bookWanted == null) {
            throw new NoBookIsFound();
        }
        return bookWanted;
    }


}

