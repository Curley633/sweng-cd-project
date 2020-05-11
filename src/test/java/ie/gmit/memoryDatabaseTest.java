package ie.gmit;

import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class memoryDatabaseTest {
    memoryDatabase thisMemoryDatabase;
    List<String> correctMemoryTypeData = Arrays.asList("SSD", "HDD", "RAM", "SD", "SHD");
    List<String> correctCapAndPriceData = Arrays.asList("8GB €" + 60.0);
    double correctPriceDataExample = 49;
    ArrayList<String> incorrectCapAndPriceData = new ArrayList();

    @BeforeEach
    public void init()
    {
        thisMemoryDatabase = new memoryDatabase();
    }

    @DisplayName("Testing connection to database")
    @Test
    public void testGetConnection() {
        assertEquals("Connected to Database", memoryDatabase.getConnection());
    }

    @DisplayName("Testing getting memoryTypes")
    @Test
    public void testGetMemoryTypes()
    {
        assertEquals(correctMemoryTypeData, memoryDatabase.getMemTypes(), "Success getting memory types");
    }

    @DisplayName("Testing getting productID")
    @Test
    public void testGetProductID()
    {
        assertEquals(1, memoryDatabase.getProductID("SSD", 0));
    }

    @DisplayName("Testing decrementing quantity, positive")
    @Test
    public void testDecrementQuantityPositive()
    {
        assertEquals(1, memoryDatabase.decrementQuantity(1, 1));
    }

    @DisplayName("Testing decrementing quantity, negative")
    @Test
    public void testDecrementQuantityNegative()
    {
        assertEquals(0, memoryDatabase.decrementQuantity(0, 1));
    }

    @DisplayName("Testing getting price")
    @Test
    public void testPrice()
    {
        assertEquals(correctPriceDataExample, memoryDatabase.getPrice(2), "Success testing getCapacityAndPrice method");
    }

    @DisplayName("Testing getting capacity")
    @Test
    public void testGetCapacityAndPrice() throws Exception
    {
        assertEquals(correctCapAndPriceData, memoryDatabase.getCapacityAndPrice("RAM"), "Success testing getCapacityAndPrice method");
    }

    @DisplayName("Checking capacityAndPrice Exception")
    @Test
    public void testGetCapacityAndPriceException() throws Exception
    {
        assertEquals(incorrectCapAndPriceData, memoryDatabase.getCapacityAndPrice(""), "Success testing getCapacityAndPrice Exception");
    }

    @DisplayName("Testing getting brand name")
    @Test
    public void testGetBrand() throws Exception
    {
        assertEquals("Kingston", memoryDatabase.getBrand(1));
    }

    //Unable to tst getting negative values as havent setup a mock database to be able to test

//    @Test(expected = Exception.class)
//    public void testGetMemoryTypesException() {
//        assertEquals(incorrectMemoryTypeData, memoryDatabase.getMemTypes());
//    }
//    @Test
//    void testGetConnection() {
//
//    }
}