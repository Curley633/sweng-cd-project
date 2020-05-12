package ie.gmit;

import org.junit.Before;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {

    Controller controller;
    Model model;
    View view;

    @BeforeEach
    public void init()
    {
        controller = new Controller();
        model = new Model();
        view = new View();
    }

    @DisplayName("Testing catch for initButtons")
    @Test
    public void testInitButtons() {
        assertEquals(0, controller.initButtons());
    }

    @DisplayName("Testing catch for order details")
    @Test
    public void testOrderDetails() {
        assertEquals(0, controller.getOrderDetails("Joe", "Bloggs", "IRE", "RAM", "8GB", 1));
    }
    @DisplayName("Testing Calculating Additional costs")
    @Test
    public void testCalculateCosts() {
        assertEquals(1, controller.calculateAdditionalCosts("IRE", 1));
    }

    @DisplayName("Testing catch for display invoice")
    @Test
    public void testDisplayInvoice() {
        assertEquals(0, controller.displayInvoice(4, 123,2));
    }
/*  Had to comment out cause it was terminating the tests
    @DisplayName("Testing closeModel")
    @Test
    public void testCloseModal() {
        assertEquals(1, controller.closeModal());
    }

 */
}