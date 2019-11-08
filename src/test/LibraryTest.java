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
    public void before() {
        library = new Library();
    }

}