
import exceptions.NameIsEmptyString;
import exceptions.NoBookIsFound;
import exceptions.NothingFoundExceptions;
import model.*;

import model.NormalBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Library;
import ui.LibraryApplication;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;




class ExceptionTest {

    private Book book;

    @Test
    void testEmptyStringNameNotEmpty(){
        try {book = new NormalBook("name","author");

    } catch (NameIsEmptyString e) {
            fail();
        }

    }

    @Test
    void testEmptyStringNameWhenEmpty() {
        //expect the book name is empty string
        try {
            book = new NormalBook("","");

        } catch (NameIsEmptyString e) {
            //just do nothing
        }
    }
}
