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
        assertThrows(IllegalArgumentException.class, () -> new Model("","meskal"));
    }
    @Test
    void testConstructorNoLastName()
    {
        assertThrows(IllegalArgumentException.class, () -> new Model("john",""));
    }
    @Test
    void testConstructor() {
        thisModel = new Model("john", "meskal");
        assertEquals("john", thisModel.getFirstname());
        assertEquals("meskal", thisModel.getLastname());
    }
}


