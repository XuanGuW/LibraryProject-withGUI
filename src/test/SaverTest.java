import model.NormalBook;
import main.ui.Library;
import main.ui.Loader;
import main.ui.Saver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        textSave = "bookTest1";
        textLoad = "bookTest1";
        saver.save(library.getAvailableBooksList(),textSave);
        loader.load(library.getAvailableBooksList(),textLoad);
        assertEquals(library.getAvailableBooksList().get(0),b);

    }

    @Test
    public void testSaver2Books() throws IOException {
        library.addABook(b2);
        textSave = "bookTest2";
        textLoad = "bookTest2";
        saver.save(library.getAvailableBooksList(),textSave);
        loader.load(library.getAvailableBooksList(),textLoad);
        assertEquals(library.getAvailableBooksList().get(0),b);
        assertEquals(library.getAvailableBooksList().get(1),b2);


    }







}
