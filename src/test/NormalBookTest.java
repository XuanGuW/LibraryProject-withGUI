import main.ui.Book;
import main.ui.NormalBook;
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
}
