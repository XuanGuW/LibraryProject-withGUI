import exceptions.NameIsEmptyString;
import exceptions.NoBookIsFound;
import model.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Library;


import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    private Library libraryWithABook;
    private Library libraryEmpty;
    private Book book;

    @BeforeEach
    void before() {
        libraryWithABook = new Library();
        libraryEmpty = new Library();
        try {
            book = new NormalBook("book","author");
        } catch (NameIsEmptyString emptyString) {
            fail();
        }
        libraryWithABook.getLibraryBooks().put(book.getName() + " " + book.getAuthor(),book);

    }

    @Test
    void testSetLibraryBooks() {
        libraryEmpty.setLibraryBooks(libraryWithABook.getLibraryBooks());
        assertEquals(libraryWithABook.getLibraryBooks(), libraryEmpty.getLibraryBooks());
    }

    @Test
    void testFindABook() {
        try {
            assertEquals(book,libraryWithABook.findABook(book.getName(),book.getAuthor()));
        } catch (NoBookIsFound noBookIsFound) {
            fail();
        }

        try {
            libraryEmpty.findABook(book.getName(),book.getAuthor());
        } catch (NoBookIsFound noBookIsFound){
            System.out.println("pass!");
        }

    }

    @Test
    void testAddABook(){
        libraryEmpty.addABook(book);
        assertTrue(libraryEmpty.getLibraryBooks().containsKey(book.getName() + " " + book.getAuthor()));
    }


}