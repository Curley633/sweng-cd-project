package ie.gmit;

import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class memoryDatabaseTest {
    memoryDatabase thisMemoryDatabase;
    List<String> correctMemoryTypeData = Arrays.asList("SSD", "HDD", "RAM", "SD", "SHD");
    //    List<String> incorrectMemoryTypeData = Arrays.asList("DSS", "DDH", "MAR");
    List<String> correctCapAndPriceData = Arrays.asList("8GB €" + 60.0);
    ArrayList<String> incorrectCapAndPriceData = new ArrayList();

    @BeforeEach
    public void init()
    {
        thisMemoryDatabase = new memoryDatabase();
    }
    @Test
    public void testGetConnection() {
//        Exception exception = assertThrows(Exception.class, () -> {
//            memoryDatabase.getConnection();
//        });
        assertEquals("Connected to Database", memoryDatabase.getConnection());
    }
    @Test
    public void testGetMemoryTypes()
    {
        assertEquals(correctMemoryTypeData, memoryDatabase.getMemTypes(), "Success getting memory types");
    }
    @Test
    public void testGetProductID()
    {
        assertEquals(1, memoryDatabase.getProductID("SSD", 0));
//        assertEquals(IllegalArgumentException.class, memoryDatabase.getProductID("", 4));
    }
    @Test
    public void testDecrementQuantityPositive()
    {
        assertEquals(1, memoryDatabase.decrementQuantity(1));
    }
    @Test
    public void testDecrementQuantityNegative()
    {
        assertEquals(0, memoryDatabase.decrementQuantity(0));
    }
    @Test
    public void testGetCapacityAndPrice() throws Exception
    {
        assertEquals(correctCapAndPriceData, memoryDatabase.getCapacityAndPrice("RAM"), "Success testing getCapacityAndPrice method");
    }
    @Test
    public void testGetCapacityAndPriceException() throws Exception
    {
        assertEquals(incorrectCapAndPriceData, memoryDatabase.getCapacityAndPrice(""), "Success testing getCapacityAndPrice Exception");
    }
    @Test
    public void testGetBrand() throws Exception
    {
        assertEquals("Kingston", memoryDatabase.getBrand(1));
    }

//    @Test(expected = Exception.class)
//    public void testGetMemoryTypesException() {
//        assertEquals(incorrectMemoryTypeData, memoryDatabase.getMemTypes());
//    }
//    @Test
//    void testGetConnection() {
//
//    }
}