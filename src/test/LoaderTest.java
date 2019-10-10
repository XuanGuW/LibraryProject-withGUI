import model.NormalBook;
import main.ui.Library;
import main.ui.Loader;
import main.ui.Saver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        textLoad = "booksTestLoad1.text";
        textSave = "bookTestSave1.text";

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
