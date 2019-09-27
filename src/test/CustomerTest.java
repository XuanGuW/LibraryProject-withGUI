import main.ui.Customer;

import main.ui.Book;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;


public class CustomerTest {
    Book b;
    Customer customer;
    Customer customerA;


    @BeforeEach
    void before(){
        b = new Book("abc","author");


        customer = new Customer("TOM",123456789);
        customerA = new Customer("JACK",987654321);


    }

    //TODO: Test Borrow Book Available : A customer borrow a book in the available list
    //TODO: outcome: the book will be lent to the customer
    @Test
    public void testBorrowBookAvailable(){
        //check that the book is available
        assertTrue(b.isAvailable());

        //a customer borrow a book
        customer.borrow(b);

        //check that the book is borrowed by the customer
        assertFalse(b.isAvailable());
        assertEquals(customer, b.getBorrower());


    }

    //TODO: Test Borrow Book Unavailable : A customer borrow a book unavailable(already lent to others)
    //TODO: outcome: the book is still borrowed by the previous customer
    @Test
    public void testBorrowBookUnavailable() {
        customerA.borrow(b);
        //check that the book is unavailable
        assertFalse(b.isAvailable());
        //a customer borrow a book
        customer.borrow(b);
        //check that the book is borrowed by the previous customer
        assertFalse(b.isAvailable());
        assertNotEquals(customer,b.getBorrower());
        assertEquals(customerA,b.getBorrower());
    }

    //TODO: Test Return Book With Right Customer Information: A customer return a book that he borrowed
    //TODO: outcome: the book returns to the library

    @Test
    public void testReturnBookWithRightCustomerInformation() {
        //a customer borrowed the book
        customer.borrow(b);
        //check that the book was lent to the customer
        assertEquals(customer, b.getBorrower());

        //return the book
        customer.returnBook(b);

        //check the book is available
        assertTrue(b.isAvailable());
    }

    //TODO: Test Return Book Without Right Customer Information: A book is returned not by the borrower
    //TODO: outcome: the book fail to return to the library

    @Test
    public void testReturnBookWithouRightCustomerInformation() {
        customerA.borrow(b);

        //check that the book was lent to the customer
        assertNotEquals(b.getBorrower(),customer);
        //return the book
        customer.returnBook(b);
        //check the book is unavailable
        assertFalse(b.isAvailable());
    }



}
