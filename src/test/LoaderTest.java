
import model.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Library;
import ui.Loader;
import ui.Saver;

import java.io.IOException;

public class LoaderTest {

    Saver saver;
    Library library;
    Loader loader;
    NormalBook b;
    String textLoad;
    String textSave;

    @BeforeEach
    void before(){
        textLoad = "/Users/guxuan/Desktop/project_t8u2b/src/bookTest1.txt";
        textSave = "/Users/guxuan/Desktop/project_t8u2b/src/bookTest1.txt";

        library = new Library();
        b = new NormalBook("ASongOfIceAndFire","GeorgeR.R.Martin");
        library.addABook(b);

    }

    @Test
    public void testSaver() throws IOException {
        saver.save(library.getAvailableBooksList(),textSave);

        loader.load(library.getAvailableBooksList(),textLoad);
        assertEquals(library.getAvailableBooksList().get(0),b);
    }







}
