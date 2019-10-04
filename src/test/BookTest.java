import main.ui.Book;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BookTest {
    Book book;

    @Test
    public void testANewBookIsAvailable(){
        book = new Book("","");
        assertTrue(book.isAvailable());
    }
    @Test
    public void testABookWithoutBorrower(){
        book = new Book("","");
        assertEquals(null,book.getBorrower());

    }
}
