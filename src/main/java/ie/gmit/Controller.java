package ie.gmit;

import javax.swing.*;

public class Controller {
    private Model model;
    private View view;
    private String brand;
    private int productID;

    public Controller(Model m, View v) {
        model = m;
        view = v;
    }

    public Controller(  ) {

    }

    public void initButtons() {
        view.getConfirmOrderButton().addActionListener(e -> confirmOrder(
                view.getFirstnameTextfield().getText(),
                view.getLastnameTextfield().getText(),
                view.getDeliveryCountryTextfield().getText(),
                (String)view.getTypeComboBox().getSelectedItem(),
                (String)view.getCapacityComboBox().getSelectedItem(),
                Integer.parseInt(view.getQuantityTextfield().getText())));
        view.getClose().addActionListener(e -> closeModal());
    }
    public int confirmOrder(String firstName, String lastName, String country, String memType, String capacity, int quantity) {
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

        try {
            productID = memoryDatabase.getProductID(model.getMemoryType(),
                    view.getCapacityComboBox().getSelectedIndex());

            brand = memoryDatabase.getBrand(productID);
            memoryDatabase.decrementQuantity(productID, quantity);
        } catch(Exception e) {
            System.out.println(e);
        }
        model.setBrand(brand);
        System.out.println("Brand Name: " + brand);

        AdditionalCosts additionalCosts = new AdditionalCosts();

        int shippingCost = additionalCosts.addShippingCost(country);
        System.out.println("Shipping Cost: " + shippingCost);

        double price;
        double priceIncVAT;

        price = memoryDatabase.getPrice(productID);
        System.out.println("Price : " + price);
        priceIncVAT = additionalCosts.addVAT(price);

        int estimatedDelivery = additionalCosts.estimatedDeliveryDate(country);
        System.out.println("Deliver Date: " + estimatedDelivery);

        if(firstName != "" | lastName != "") {
            JOptionPane.showMessageDialog(null, "Thank you : " + "\n" + model.getFirstname()
                    + " " + model.getLastname() + "!\n\nOrder Info: " + model.getBrand() + "\n\t" + model.getMemoryType()
                    + "\n\t" + model.getCapacityAndPrice() + "\n\t" + "Quantity: " + model.getQuantity() + "\n\t" + "Shipping Cost: €" + shippingCost + "\n\t"
                    + "Price Inc VAT: €" + priceIncVAT
                    + "\n\t" + "Est Delivery: " + estimatedDelivery + " days", "Info", JOptionPane.INFORMATION_MESSAGE);
            return 1;
        } else {
            throw new IllegalArgumentException("Order not Confirmed! Check fields!");
        }
    }

    private void closeModal() {
        System.exit(0);
    }
}


