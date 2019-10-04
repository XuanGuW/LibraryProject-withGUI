import main.ui.NormalBook;
import main.ui.Library;
import main.ui.Loader;
import main.ui.Saver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
        textSave = "booktest1";
        textLoad = "booktest1";
        saver.save(library.availableNormalBooks,textSave);
        loader.load(library.availableNormalBooks,textLoad);
        assertEquals(library.availableNormalBooks.get(0),b);

    }

    @Test
    public void testSaver2Books() throws IOException {
        library.addABook(b2);
        textSave = "booktest2";
        textLoad = "booktest2";
        saver.save(library.availableNormalBooks,textSave);
        loader.load(library.availableNormalBooks,textLoad);
        assertEquals(library.availableNormalBooks.get(0),b);
        assertEquals(library.availableNormalBooks.get(1),b2);


    }







}
