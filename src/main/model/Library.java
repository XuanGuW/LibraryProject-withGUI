package model;



import exceptions.NoBookIsFound;
import java.util.HashMap;
import java.util.Map;



public class Library {
    private Map<String, Book> libraryBooks;


    public Library() {
        this.libraryBooks = new HashMap<>();

    }

    public Map<String, Book> getLibraryBooks() {
        return libraryBooks;
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

