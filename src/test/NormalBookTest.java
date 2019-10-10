import model.Book;
import model.NormalBook;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class NormalBookTest {
    Book normalBook;

    @Test
    public void testANewBookIsAvailable(){
        normalBook = new NormalBook("","");
        assertTrue(normalBook.isAvailable());
    }
    @Test
    public void testABookWithoutBorrower(){
        normalBook = new NormalBook("","");
        assertEquals(null, normalBook.getBorrower());

    }

    @Test
    public void testNormalBookSetter() {
        normalBook = new NormalBook("","");
        normalBook.setName("Book");
        normalBook.setAuthor("Author");
        assertEquals("Book",normalBook.getName());
        assertEquals("Author",normalBook.getAuthor());
    }



}
