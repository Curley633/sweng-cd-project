package ie.gmit;

import ie.gmit.Controller;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Assemble all the pieces of the MVC
        Model m = new Model("John", "Meskal");

        //View v = new View("Details");
        EventQueue.invokeLater(new View("Test"));
        //Controller c = new Controller(m, v);
        //c.initController();
    }
}
