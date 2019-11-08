import exceptions.BookAlreadyExistException;
import exceptions.NameIsEmptyString;
import exceptions.NoBookIsFound;
import model.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Library;


import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    Library library;
    @BeforeEach
    public void before(){
        library = new Library();}


    @Test
    //TODO: Test Add A New Book: add a new book to the library
    //TODO: outcome: the book is added to the library

    public void testAddANewBook() {
        //check the book is not in the library
        assertEquals(library.getLibraryBooks().size(), 0);

        //add the book
        try {
            try {
                library.addABook("name","author");
            } catch (BookAlreadyExistException e) {
                fail();
            }
        } catch (NameIsEmptyString emptyString) {
            fail();
        }

        //check the book is added to the library
        try {
            library.findABook("name","author");
        } catch (NoBookIsFound noBookIsFound) {
            fail();
        }


    }


    @Test
    //TODO: Test Add An Existing Book: add a book that was already in the library
    //TODO: outcome: the book will only be added once
    void testAddAnExistingBook() {
        //check the book is not in the library
        try {
            library.findABook("name","author");
        } catch (NoBookIsFound ignored) {

        }

        //add the book
        try {
            try {
                library.addABook("name","author");
            } catch (BookAlreadyExistException e) {
                fail();
            }
        } catch (NameIsEmptyString emptyString) {
            fail();
        }

        //check the book is in the library
        assertEquals(1, library.getLibraryBooks().size());

        //add the book again
        try {
            try {
                library.addABook("name","author");
            } catch (BookAlreadyExistException e) {
                System.out.println("pass!");
            }
        } catch (NameIsEmptyString emptyString) {
            fail();
        }

        //check the book only appears once in the library
        assertEquals(1, library.getLibraryBooks().size());


    }

    @Test
    void testLibraryGetBooks() throws NameIsEmptyString {
        try {
            library.addABook("name","author");
            assertEquals(library.getLibraryBooks().get("name" + " " + "author"), new NormalBook("name", "author"));
        } catch (NameIsEmptyString | BookAlreadyExistException emptyString) {
            fail();
        }

    }




}
