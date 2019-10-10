import model.Book;
import model.Magazine;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MagazineTest {
    Book magazine;


    @Test
    public void testMagazineConstructor() {
        magazine = new Magazine("","");
        assertTrue(magazine.getName() == "");
        assertTrue(magazine.getAuthor() == null);

    }





}
