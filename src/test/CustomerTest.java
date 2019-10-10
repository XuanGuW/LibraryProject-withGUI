import main.ui.Book;
import main.ui.Customer;

import main.ui.NormalBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class CustomerTest {
    Book b;
    Customer customerA;
    Customer customerB;
    List<Book> myBooksA;
    List<Book> myBooksB;


    @BeforeEach
    void before(){
        b = new NormalBook("abc","author");
        myBooksA = new ArrayList<>();
        myBooksB = new ArrayList<>();

        customerA = new Customer("TOM","123456789", myBooksA);
        customerB = new Customer("JACK","987654321", myBooksB);


    }

    //TODO: Test Borrow Book Available : A customer borrow a book in the available list
    //TODO: outcome: the book will be lent to the customer
    @Test
    public void testBorrowBookAvailable(){
        //check that the book is available
        assertTrue(b.isAvailable());

        //a customer borrow a book
        customerA.borrow(b);

        //check that the book is borrowed by the customer
        assertFalse(b.isAvailable());
        assertEquals(customerA, b.getBorrower());


    }

    //TODO: Test Borrow Book Unavailable : A customer borrow a book unavailable(already lent to others)
    //TODO: outcome: the book is still borrowed by the previous customer
    @Test
    public void testBorrowBookUnavailable() {
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

    //TODO: Test Return Book With Right Customer Information: A customer return a book that he borrowed
    //TODO: outcome: the book returns to the library

    @Test
    public void testReturnBookWithRightCustomerInformation() {
        //a customer borrowed the book
        customerA.borrow(b);
        //check that the book was lent to the customer
        assertEquals(customerA, b.getBorrower());

        //return the book
        customerA.returnBook(b);

        //check the book is available
        assertTrue(b.isAvailable());
    }

    //TODO: Test Return Book Without Right Customer Information: A book is returned not by the borrower
    //TODO: outcome: the book fail to return to the library

    @Test
    public void testReturnBookWithoutRightCustomerInformation() {
        customerB.borrow(b);

        //check that the book was lent to the customer
        assertNotEquals(b.getBorrower(), customerA);
        //return the book
        customerA.returnBook(b);
        //check the book is unavailable
        assertFalse(b.isAvailable());
    }

    @Test
    public void testMyBooks(){
        customerA.borrow(b);

        assertEquals(customerA.getMyBooks().size(),1);
        assertEquals(customerA.getMyBooks().get(0),b);

    }

}
