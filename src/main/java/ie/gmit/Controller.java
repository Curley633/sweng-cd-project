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
        initView();
    }
    public void initView() {
        view.getFirstnameTextfield().setText(model.getFirstname());
        view.getLastnameTextfield().setText(model.getLastname());

    }
    public void initController() {
        view.getConfirmOrderButton().addActionListener(e -> confirmOrder());
        view.getClose().addActionListener(e -> closeModal());
    }
    private void confirmOrder() {
        model.setFirstname(view.getFirstnameTextfield().getText());
        model.setLastname(view.getLastnameTextfield().getText());
        model.setMemoryType((String) view.getTypeComboBox().getSelectedItem());
        model.setCapacityAndPrice((String) view.getCapacityComboBox().getSelectedItem());
        try {
            productID = memoryDatabase.getProductID(model.getMemoryType(),
                    view.getCapacityComboBox().getSelectedIndex());

            brand = memoryDatabase.getBrand(productID);
            memoryDatabase.decrementQuantity(productID);
        }catch(Exception e){
            System.out.println(e);
        }

        model.setBrand(brand);

        JOptionPane.showMessageDialog(null, "Thank you : " + "\n" + model.getFirstname()
                + " " + model.getLastname()  + "!\n\nOrder Info: \n" + model.getBrand() + "\n\t" + model.getMemoryType() + "\n\t" + model.getCapacityAndPrice(), "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void closeModal() {
        System.exit(0);
    }
}


