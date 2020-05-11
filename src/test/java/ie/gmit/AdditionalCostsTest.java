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

    @DisplayName("Adding shipping price")
    @Test
    public void testAddShippingCost()
    {
        assertEquals(4,additionalCosts.addShippingCost("IRE"));
        assertEquals(5,additionalCosts.addShippingCost("UK"));

    }

    @DisplayName("Checking shipping price exception")
    @Test
    public void testAddShippingCostException() throws Exception
    {
        assertThrows(IllegalArgumentException.class,() -> additionalCosts.addShippingCost("None"));
    }

    @DisplayName("Adding VAT")
    @Test
    public void testAddVAT()
    {
        assertEquals((61.487700000000004), additionalCosts.addVAT(49.99));
    }

    @DisplayName("Checking add VAT exception")
    @Test
    public void testAddVATException()
    {
        assertThrows(IllegalArgumentException.class,() -> additionalCosts.addVAT(-4));
    }

    @DisplayName("Testing estimated Delivery date")
    @Test
    public void testEstimatedDeliveryDate()
    {
        assertEquals(2, additionalCosts.estimatedDeliveryDate("IRE"));
        assertEquals(5, additionalCosts.estimatedDeliveryDate("UK"));
    }

    @DisplayName("Checking delivery date exception")
    @Test
    public void testEstimatedDeliveryDateException() throws Exception
    {
        assertThrows(IllegalArgumentException.class,() -> additionalCosts.estimatedDeliveryDate("Spain"));
    }
}
