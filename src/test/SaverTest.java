import model.NormalBook;
import ui.Library;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Loader;
import ui.Saver;

import java.io.IOException;

public class SaverTest {

    Saver saver;
    Library library;
    Loader loader;
    NormalBook b;
    String textLoad;
    String textSave;
    NormalBook b2;

    @BeforeEach
    void before(){
        library = new Library();
        b = new NormalBook("ASongOfIceAndFire","GeorgeR.R.Martin");
        library.addABook(b);
        b2 = new NormalBook("HarryPotter","J.K.Rolling");

    }

    @Test
    public void testSaver() throws IOException {
        textSave = "/Users/guxuan/Desktop/project_t8u2b/src/bookTest1.txt";
        textLoad = "/Users/guxuan/Desktop/project_t8u2b/src/bookTest1.txt";
        saver.save(library.getAvailableBooksList(),textSave);
        loader.load(library.getAvailableBooksList(),textLoad);
        assertEquals(library.getAvailableBooksList().get(0),b);

    }

    @Test
    public void testSaver2Books() throws IOException {
        library.addABook(b2);
        textSave = "/Users/guxuan/Desktop/project_t8u2b/src/bookTest2.txt";
        textLoad = "/Users/guxuan/Desktop/project_t8u2b/src/bookTest2.txt";
        saver.save(library.getAvailableBooksList(),textSave);
        loader.load(library.getAvailableBooksList(),textLoad);
        assertEquals(library.getAvailableBooksList().get(0),b);
        assertEquals(library.getAvailableBooksList().get(1),b2);


    }







}
