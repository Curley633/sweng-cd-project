package ie.gmit;

import ie.gmit.Controller;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Assemble all the pieces of the MVC
        Model m = new Model("John", "Appleseed");

        View v ;
        EventQueue.invokeLater(v = new View("Details"));
        Controller c = new Controller(m, v);
        c.initController();
    }
}
