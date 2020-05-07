package ie.gmit;

import ie.gmit.Controller;

public class Main {
    public static void main(String[] args) {
        // Assemble all the pieces of the MVC
        Model m = new Model("H91W960", "James", "Curley", "curley@mail.com", "123");
        View v = new View("Details");
        Controller c = new Controller(m, v);
        c.initController();
    }
}
