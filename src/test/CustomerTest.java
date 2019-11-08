
import exceptions.NameIsEmptyString;
import model.*;

import model.NormalBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import java.util.Map;

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
        assertTrue(b.isAvailable());

        //a customer borrow a book
        customerA.borrow(b);

        //check that the book is borrowed by the customer
        assertFalse(b.isAvailable());
        assertEquals(customerA, b.getBorrower());
    }


    @Test
    void testBorrowBookUnavailable() {
        customerB.borrow(b);
        //check that the book is unavailable
        assertFalse(b.isAvailable());
        //a customer borrow a book
        customerA.borrow(b);
        //check that the book is borrowed by the previous customer
        assertFalse(b.isAvailable());
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

        assertTrue(b.isAvailable());

    }


    @Test
    void testReturnBookWithoutRightCustomerInformation() {
        customerB.borrow(b);

        //check that the book was lent to the customer
        assertNotEquals(b.getBorrower(), customerA);
        //return the book
        customerA.returnBook(b);
        //check the book is unavailable
        assertFalse(b.isAvailable());
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


    }

    @Test
    void testToString() {
        assertEquals(customerA.toString(),"TOM 123456789");
    }
}
