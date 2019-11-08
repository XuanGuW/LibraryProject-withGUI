
import exceptions.BookAlreadyExistException;
import exceptions.NameIsEmptyString;
import model.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Library;
import ui.Loader;
import ui.Saver;

import java.io.IOException;

class LoaderTest {


    private Library library;
    private NormalBook b;
    private String textLoad;
    private String textSave;

    @BeforeEach
    void before() throws IOException, NameIsEmptyString {
        textLoad = "/Users/guxuan/Desktop/project_t8u2b/src/bookTest1.txt";
        textSave = "/Users/guxuan/Desktop/project_t8u2b/src/bookTest1.txt";

        library = new Library();
        try {
            b = new NormalBook("ASongOfIceAndFire","GeorgeR.R.Martin");

        } catch (NameIsEmptyString emptyString) {
            System.out.println("Book name should not be empty");
        }

        try {
            library.addABook(b.getName(),b.getAuthor());
        } catch (BookAlreadyExistException e) {
           fail();
        }

    }

    @Test
    void testSaver() throws IOException {
        Saver.saveBook(library.getLibraryBooks(),textSave);
        Loader.loadBooks(library.getLibraryBooks(),textLoad);
        assertEquals(library.getLibraryBooks().get(b.getName() + " " + b.getAuthor()),b);
    }







}
