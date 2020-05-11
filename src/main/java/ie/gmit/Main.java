package ie.gmit;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Model m = new Model("John", "Appleseed", "IRE");
        AdditionalCosts a = new AdditionalCosts();
//        a.addVAT( 49.99);

        View v ;
        EventQueue.invokeLater(v = new View());
        Controller c = new Controller(m, v);
        c.initButtons();
    }
}
