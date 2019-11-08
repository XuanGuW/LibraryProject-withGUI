import exceptions.BookAlreadyExistException;
import exceptions.NameIsEmptyString;
import model.NormalBook;
import model.Library;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Loader;
import ui.Saver;

import java.io.IOException;

public class SaverTest {

    private Library library;
    private NormalBook b;
    private String textLoad;
    private String textSave;
    private NormalBook b2;

    @BeforeEach
    void before(){
        library = new Library();
        try {
            b = new NormalBook("ASongOfIceAndFire","GeorgeR.R.Martin");
        } catch (NameIsEmptyString emptyString) {
            System.out.println("Book name should not be empty");
        }

        try {
            b2 = new NormalBook("HarryPotter","J.K.Rolling");
        } catch (NameIsEmptyString emptyString) {
            System.out.println("Book name should not be empty");
        }


        try {
            library.addABook(b.getName(),b.getAuthor());
        } catch (NameIsEmptyString emptyString) {
            System.out.println("Book name should not be empty");
        } catch (BookAlreadyExistException e) {
            e.printStackTrace();
        }
        try {
            library.addABook(b2.getName(),b2.getAuthor());
        } catch (NameIsEmptyString emptyString) {
            System.out.println("Book name should not be empty");
        } catch (BookAlreadyExistException e) {
            e.printStackTrace();
        }

    }

    @Test
    void testSaver() throws IOException {
        textSave = "/Users/guxuan/Desktop/project_t8u2b/src/bookTest1.txt";
        textLoad = "/Users/guxuan/Desktop/project_t8u2b/src/bookTest1.txt";
        Saver.saveBook(library.getLibraryBooks(),textSave);
        Loader.loadBooks(library.getLibraryBooks(),textLoad);
        assertEquals(library.getLibraryBooks().get(b.getName() + " " + b.getAuthor()),b);

    }

    @Test
    public void testSaver2Books() throws IOException {
        library.getLibraryBooks().put(b2.getName(),b2);
        textSave = "/Users/guxuan/Desktop/project_t8u2b/src/bookTest2.txt";
        textLoad = "/Users/guxuan/Desktop/project_t8u2b/src/bookTest2.txt";
        Saver.saveBook(library.getLibraryBooks(),textSave);
        Loader.loadBooks(library.getLibraryBooks(),textLoad);
        assertEquals(library.getLibraryBooks().get(b.getName() + " " + b.getAuthor()),b);
        assertEquals(library.getLibraryBooks().get(b2.getName() + " " + b2.getAuthor()),b2);


    }







}
