import exceptions.NameIsEmptyString;
import model.Book;
import model.NormalBook;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class NormalBookTest {
    Book normalBook;

    @Test
    public void testANewBookIsAvailable() throws NameIsEmptyString {
        normalBook = new NormalBook("name","author");
        assertTrue(normalBook.isAvailable());
    }
    @Test
    public void testABookWithoutBorrower() throws NameIsEmptyString {
        normalBook = new NormalBook("name","author");
        assertEquals(null, normalBook.getBorrower());

    }

    @Test
    public void testNormalBookSetter() throws NameIsEmptyString {
        normalBook = new NormalBook("name","author");
        normalBook.setName("Book");
        normalBook.setAuthor("Author");
        assertEquals("Book",normalBook.getName());
        assertEquals("Author",normalBook.getAuthor());
    }



}
