import exceptions.NameIsEmptyString;
import model.Book;
import model.Customer;
import model.NormalBook;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class NormalBookTest {
    private Book normalBook;
    private Customer customer;

    @Test
    void testANewBookIsAvailable() throws NameIsEmptyString {
        normalBook = new NormalBook("name","author");
        customer = new Customer("Customer","phone");
        assertTrue(normalBook.isAvailable());
    }
    @Test
    void testABookWithoutBorrower() throws NameIsEmptyString {
        normalBook = new NormalBook("name","author");
        assertNull(normalBook.getBorrower());

    }

    @Test
    void testNormalBookSetter() throws NameIsEmptyString {
        normalBook = new NormalBook("name","author");
        normalBook.setName("Book");
        normalBook.setAuthor("Author");
        normalBook.setBorrower(customer);
        assertEquals("Book",normalBook.getName());
        assertEquals("Author",normalBook.getAuthor());
        assertEquals(customer,normalBook.getBorrower());
    }

    @Test
    void testToString() throws NameIsEmptyString {
        normalBook = new NormalBook("name","author");
        assertEquals(normalBook.toString(), "name" + " " + "author");
    }





}
