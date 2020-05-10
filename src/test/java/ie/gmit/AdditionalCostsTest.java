package ie.gmit;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
public class AdditionalCostsTest {
    AdditionalCosts additionalCosts;
    @BeforeEach
    public void init()
    {
        additionalCosts = new AdditionalCosts();
    }
    @Test
    public void testAddShippingCost()
    {
        assertEquals(4,additionalCosts.addShippingCost("IRE"));
    }
    @Test
    public void testAddShippingCostException() throws Exception
    {
        assertThrows(IllegalArgumentException.class,() -> additionalCosts.addShippingCost("None"));
    }
    @Test
    public void testAddVAT()
    {
        assertEquals((61.487700000000004), additionalCosts.addVAT(49.99));
    }
    @Test
    public void testAddVATException()
    {
        assertThrows(IllegalArgumentException.class,() -> additionalCosts.addVAT(-4));
    }
    @Test
    public void testEstimatedDeliveryDate()
    {
        assertEquals(5, additionalCosts.estimatedDeliveryDate("UK"));
    }
    @Test
    public void testEstimatedDeliveryDateException() throws Exception
    {
        assertThrows(IllegalArgumentException.class,() -> additionalCosts.estimatedDeliveryDate("Spain"));
    }
}
