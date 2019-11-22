
import exceptions.NameIsEmptyString;
import model.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Library;
import ui.Loader;
import ui.Saver;

import java.io.IOException;

class SaverAndLoaderTest {



    private Library library;
    private Book b1;
    private Book b2;
    private String textLoad;
    private String textSave;


    private Customers customers;
    private Customer customer1;
    private Customer customer2;
    private String textSaveCustomer;
    private String textLoadCustomer;


    @BeforeEach
    void before1() throws IOException, NameIsEmptyString {

        textLoad = "/Users/guxuan/Desktop/project_t8u2b/src/bookTest1.txt";
        textSave = "/Users/guxuan/Desktop/project_t8u2b/src/bookTest1.txt";
        textSaveCustomer = "/Users/guxuan/Desktop/project_t8u2b/src/CustomerSaverText.txt";
        textLoadCustomer = "textLoadCustomer";


        library = new Library();
        try {
            b1 = new NormalBook("ASongOfIceAndFire","GeorgeR.R.Martin");

        } catch (NameIsEmptyString emptyString) {
            System.out.println("Book name should not be empty");
        }

        try {
            b2 = new NormalBook("HarryPotter","J.K.Rolling");
        } catch (NameIsEmptyString emptyString) {
            System.out.println("Book name should not be empty");
        }

        library.getLibraryBooks().put(b1.getName() + " " + b1.getAuthor(),b1);



        customers = new Customers();
        customer1 = new Customer("Tom","123456");
        customer2 = new Customer("Jerry","654321");
        customers.getCustomers().put(customer1.getName() + " " +customer1.getPhoneNumber(),customer1);
        customers.getCustomers().put(customer2.getName() + " " +customer2.getPhoneNumber(),customer2);




    }

    @Test
    void testLoadBooks() throws IOException {
        Saver.saveBooks(library.getLibraryBooks(),textSave);
        Loader.loadBooks(library.getLibraryBooks(),textLoad);
        assertEquals(library.getLibraryBooks().get(b1.getName() + " " + b1.getAuthor()),b1);
    }

    @Test
    void testLoadCustomers() throws IOException {
        Saver.saveCustomers(customers.getCustomers(),textSaveCustomer);

    }







}
