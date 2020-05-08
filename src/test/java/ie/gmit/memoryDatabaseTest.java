package ie.gmit;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class memoryDatabaseTest {
    memoryDatabase thisMemoryDatabase;

    @BeforeEach
    void init()
    {
        thisMemoryDatabase = new memoryDatabase();
    }
    @Test
    void testDecrementQuantityPositive()
    {
        assertEquals(1, memoryDatabase.decrementQuantity("HDD", 3000));
    }
    @Test
    void testDecrementQuantityNegative()
    {
        assertEquals(0, memoryDatabase.decrementQuantity("HDD", 2000));
    }
}
