package model;



import exceptions.NoBookIsFound;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;


public class Library extends Observable {

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

    public void addABook(Book book) {
        libraryBooks.put(book.getName() + " " + book.getAuthor(), book);
        setChanged();
        notifyObservers(book.getName() + " " + book.getAuthor());
    }



}

