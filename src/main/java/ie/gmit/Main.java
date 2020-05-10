package ie.gmit;
import java.awt.*;
public class Main {
    public static void main(String[] args) {
        Model m = new Model("John", "Appleseed");
        AdditionalCosts a = new AdditionalCosts();
//        a.addVAT( 49.99);
        View v ;
        EventQueue.invokeLater(v = new View("Details"));
        Controller c = new Controller(m, v);
        c.initButtons();
    }
}