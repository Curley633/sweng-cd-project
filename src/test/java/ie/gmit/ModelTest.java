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
        assertThrows(IllegalArgumentException.class, () -> new Model("","curley"));
    }
    @Test
    void testConstructorNoLastName()
    {
        assertThrows(IllegalArgumentException.class, () -> new Model("james",""));
    }
    @Test
    void testConstructor() {
        thisModel = new Model("james", "curley");
        assertEquals("james", thisModel.getFirstname());
        assertEquals("curley", thisModel.getLastname());
    }
}


