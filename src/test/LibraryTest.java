import main.ui.Book;
import main.ui.Library;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    Book b;
    Library library = new Library();


    @Test
    //TODO: Test Add A New Book: add a new book to the library
    //TODO: outcome: the book is added to the library

    public void testAddANewBook() {
        //check the book is not in the library
        assertEquals(library.librarySize(), 0);

        //add the book
        library.addABook(b);

        //check the book is added to the library
        assertTrue(library.contains(b));


    }


    @Test
    //TODO: Test Add An Existing Book: add a book that was already in the library
    //TODO: outcome: the book will only be added once
    public void testAddAnExistingBook() {
        //check the book is not in the library
        assertFalse(library.contains(b));

        //add the book
        library.addABook(b);

        //check the book is in the library
        assertEquals(1, library.librarySize());

        //add the book again
        library.addABook(b);

        //check the book only appears once in the library
        assertEquals(1, library.librarySize());


    }

}
