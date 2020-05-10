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

    @DisplayName("Checking Constructor with no Name")
    @Test
    void testConstructorNoName()
    {
        assertThrows(IllegalArgumentException.class, () -> new Model("",""));
    }

    @DisplayName("Checking Constructor with no Firstname")
    @Test
    void testConstructorNoFirstName()
    {
        assertThrows(IllegalArgumentException.class, () -> new Model("","Meskal"));
    }

    @DisplayName("Checking Constructor with no Lastname")
    @Test
    void testConstructorNoLastName()
    {
        assertThrows(IllegalArgumentException.class, () -> new Model("John",""));
    }

    @DisplayName("Checking Test Constructor")
    @Test
    void testConstructor() {
        thisModel = new Model("John", "Meskal");
        assertEquals("John", thisModel.getFirstname());
        assertEquals("Meskal", thisModel.getLastname());
    }
    @DisplayName("Testing Name Getters and Setters")
    @Test
    void testGetFirst_Last() {
        assertEquals("Jason", thisModel.setFirstname("Jason"));
        assertEquals("Jason", thisModel.getFirstname());
        assertEquals("Waters", thisModel.setLastname("Waters"));
        assertEquals("Waters", thisModel.getLastname());
    }
    @DisplayName("Testing getMemoryType")
    @Test
    public void testGetMemoryType() {
        assertEquals("RAM", thisModel.setMemoryType("RAM"));
        assertEquals("RAM", thisModel.getMemoryType(), "Success getting memory type after it has been set");
    }
    @DisplayName("Testing getCapacityAndPrice")
    @Test
    public void testGetCapacityAndPrice() {
        assertEquals("8GB €60.0", thisModel.setCapacityAndPrice("8GB €60.0"));
        assertEquals("8GB €60.0", thisModel.getCapacityAndPrice(), "Success getting capacity and price after it has been set");
    }
    @DisplayName("Testing getBrand")
    @Test
    public void testGetBrand() {
        assertEquals("Samsung", thisModel.setBrand("Samsung"));
        assertEquals("Samsung", thisModel.getBrand(), "Success getting brand name after it has been set");
    }

}


