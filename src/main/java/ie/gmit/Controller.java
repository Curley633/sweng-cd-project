package ie.gmit;

import javax.swing.*;

public class Controller {
    private Model model;
    private View view;
    private String brand;
    private int productID;

    public Controller(Model m, View v)
    {
        model = m;
        view = v;
    }

    public Controller()
    {

    }

    public int initButtons()
    {
        try {
            view.getConfirmOrderButton().addActionListener(e -> getOrderDetails(
                    view.getFirstnameTextfield().getText(),
                    view.getLastnameTextfield().getText(),
                    view.getDeliveryCountryTextfield().getText(),
                    (String)view.getTypeComboBox().getSelectedItem(),
                    (String)view.getCapacityComboBox().getSelectedItem(),
                    Integer.parseInt(view.getQuantityTextfield().getText())));
            view.getClose().addActionListener(e -> closeModal());
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
       return 1;
    }

    public int getOrderDetails(String firstName, String lastName, String country, String memType, String capacity, int quantity)
    {
        try {
            System.out.println("First Name: " + firstName);
            model.setFirstname(firstName);
            System.out.println("First: " + firstName);
            model.setLastname(lastName);
            System.out.println("Last: " + lastName);
            model.setCountry(country);
            System.out.println("Deivery Country: " + country);
            model.setMemoryType(memType);
            System.out.println("Memory Type: " + memType);
            model.setCapacityAndPrice(capacity);
            System.out.println("Capacity: " + capacity);
            model.setQuantity(quantity);
            System.out.println("Quantity: " + quantity);

            productID = memoryDatabase.getProductID(model.getMemoryType(),
                    view.getCapacityComboBox().getSelectedIndex());

            brand = memoryDatabase.getBrand(productID);
            memoryDatabase.decrementQuantity(productID, quantity);
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
        model.setBrand(brand);
        System.out.println("Brand Name: " + brand);

        calculateAdditionalCosts(country, productID);

        return 1;
    }

    public int calculateAdditionalCosts(String country, int productID)
    {
        AdditionalCosts additionalCosts = new AdditionalCosts();
        int shippingCost = additionalCosts.addShippingCost(country);
        System.out.println("Shipping Cost: " + shippingCost);

        double price;
        double priceIncVAT;
        int estimatedDelivery;

        price = memoryDatabase.getPrice(productID);
        System.out.println("Price : " + price);
        priceIncVAT = additionalCosts.addVAT(price);

        estimatedDelivery = additionalCosts.estimatedDeliveryDate(country);
        System.out.println("Deliver Date: " + estimatedDelivery);

        displayInvoice(shippingCost, priceIncVAT, estimatedDelivery);

        return 1;
    }

    public int displayInvoice(double shippingCost, double priceIncVAT, int estimatedDelivery)
    {
        try {
            JOptionPane.showMessageDialog(null, "Thank you : " + "\n" + model.getFirstname()
                    + " " + model.getLastname() + "!\n\nOrder Info: " + model.getBrand() + "\n\t" + model.getMemoryType()
                    + "\n\t" + model.getCapacityAndPrice() + "\n\t" + "Quantity: " + model.getQuantity() + "\n\t" + "Shipping Cost: €" + shippingCost + "\n\t"
                    + "Price Inc VAT: €" + priceIncVAT * model.getQuantity()
                    + "\n\t" + "Est Delivery: " + estimatedDelivery + " days", "Info", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ignored){
            JOptionPane.showMessageDialog(null, "please input a valid number");
            return 0;
        }
        return 1;
    }

    public int closeModal() {
        System.exit(0);
        return 1;
    }
}
