package ie.gmit;

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
//    @Test
//    public void testConfirmOrder() {
//        assertEquals(1, controller.confirmOrder("joe", "bloggs","IRE", "HDD", "500"));
//    }
}
