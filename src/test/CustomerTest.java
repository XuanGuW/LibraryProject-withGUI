
import exceptions.NameIsEmptyString;
import model.*;

import model.NormalBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class CustomerTest {
    private Book b;
    private Customer customerA;
    private Customer customerB;

    @BeforeEach
    void before(){
        try {
            b = new NormalBook("abc","author");
        } catch (NameIsEmptyString emptyString) {
            System.out.println("book name should not be empty");
        }

        customerA = new Customer("TOM","123456789");
        customerB = new Customer("JACK","987654321");
    }


    @Test
    void testBorrowBookAvailable(){
        //check that the book is available


        //a customer borrow a book
        customerA.borrow(b);

        //check that the book is borrowed by the customer

        assertEquals(customerA, b.getBorrower());
    }


    @Test
    void testBorrowBookUnavailable() {
        customerB.borrow(b);
        //a customer borrow a book
        customerA.borrow(b);

        assertNotEquals(customerA,b.getBorrower());
        assertEquals(customerB,b.getBorrower());
    }


    @Test
    void testReturnBookWithRightCustomerInformation() {
        //a customer borrowed the book
        customerA.borrow(b);
        //check that the book was lent to the customer
        assertEquals(customerA, b.getBorrower());
        //return the book
        customerA.returnBook(b);


    }


    @Test
    void testReturnBookWithoutRightCustomerInformation() {
        customerB.borrow(b);

        //check that the book was lent to the customer
        assertNotEquals(b.getBorrower(), customerA);
        //return the book
        customerA.returnBook(b);
        //check the book is unavailable

    }

    @Test
    void testMyBooks(){
        customerA.borrow(b);

        assertEquals(customerA.getMyBooks().size(),1);
        assertEquals(customerA.getMyBooks().get(b.getName()),b);

    }

    @Test
    void testSettersAndGetters() {
        customerA.setName("A");
        customerA.setPhoneNumber("123");
        customerA.setMyBooks(null);
        assertEquals("A",customerA.getName());
        assertEquals("123",customerA.getPhoneNumber());
        assertNull(customerA.getMyBooks());
    }

    @Test
    void testEqualAndHashCodeOverrides(){
        assertEquals(customerA,new Customer("TOM","123456789"));
        assertNotEquals(customerA,new Customer("tom","123456789"));
        assertEquals(customerA.hashCode(),new Customer("TOM","123456789").hashCode());
        assertNotEquals(customerA,0);
    }

    @Test
    void testToString() {
        assertEquals(customerA.toString(),"TOM 123456789");
    }
}
