import exceptions.NameIsEmptyString;
import model.Book;
import model.Customer;
import model.NormalBook;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NormalBookTest {
    private Book normalBook;
    private Customer customer;

    @BeforeEach
    void runBefore() throws NameIsEmptyString {
        normalBook = new NormalBook("name","author");
        customer = new Customer("Customer","phone");
    }



    @Test
    void testANewBookIsAvailable() {
        assertTrue(normalBook.isAvailable());
    }
    @Test
    void testABookWithoutBorrower() {

        assertNull(normalBook.getBorrower());

    }

    @Test
    void testNormalBookSetter() throws NameIsEmptyString {

        normalBook.setName("Book");
        normalBook.setAuthor("Author");
        normalBook.setCustomer(customer);
        assertEquals("Book",normalBook.getName());
        assertEquals("Author",normalBook.getAuthor());
        assertEquals(customer,normalBook.getBorrower());
    }

    @Test
    void testToString() {

        assertEquals(normalBook.toString(), "name" + " " + "author");
    }

    @Test
    void testNormalBookHashCodeAndEqualOverrides() {

        try {
            Book book = new NormalBook("name","author");
            assertEquals(normalBook.hashCode(),book.hashCode() );
            assertEquals(normalBook,book);
            assertNotEquals(normalBook,new Customer("name","123"));
        } catch (NameIsEmptyString emptyString) {
            fail();
        }

    }




}
