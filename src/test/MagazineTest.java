import model.Book;
import model.Magazine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MagazineTest {
    Magazine magazine;


    @BeforeEach
    public void testMagazineConstructor() {
        magazine = new Magazine("name","year");
        assertTrue(magazine.getName() == "name");
        assertTrue(magazine.getPublicationYear() == "year");

    }

    @Test
    public void testToString() {
        magazine = new Magazine("name", "year");
        String magazineInformation = magazine.toString();
        assertEquals(magazineInformation,"name year");


    }






}
