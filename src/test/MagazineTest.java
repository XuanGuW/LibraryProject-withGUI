import model.Book;
import model.Magazine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MagazineTest {
    private Magazine magazine;


    @BeforeEach
    void testMagazineConstructor() {
        magazine = new Magazine("name","year");
        assertEquals("name", magazine.getName());
        assertEquals("year", magazine.getPublicationYear());

    }

    @Test
    void testToString() {
        magazine = new Magazine("name", "year");
        String magazineInformation = magazine.toString();
        assertEquals(magazineInformation,"name year");


    }






}
