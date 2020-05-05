package ie.gmit;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ModelTest {

    Model thisModel;

    @BeforeEach
    void init()
    {
        thisModel = new Model();
    }
    @Test
    void testConstructorNoFirstName()
    {
        assertThrows(IllegalArgumentException.class, () -> new Model("H91W960", "","curley",
                "curley@mail.com","123"));
    }
    @Test
    void testConstructorNoLastName()
    {
        assertThrows(IllegalArgumentException.class, () -> new Model("H91W960", "james","",
                "curley@mail.com","123"));
    }
    @Test
    void testConstructor() {
        thisModel = new Model("H91W960", "james", "curley", "curley@mail.com",
                "123");
        assertEquals("H91W960", thisModel.getPostcode());
        assertEquals("james", thisModel.getFirstname());
        assertEquals("curley", thisModel.getLastname());
        assertEquals("curley@mail.com", thisModel.getEmail());
        assertEquals("123", thisModel.getPhone());
    }
}
