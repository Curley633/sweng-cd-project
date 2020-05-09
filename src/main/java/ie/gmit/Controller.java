package ie.gmit;

import javax.swing.*;

public class Controller {
    private Model model;
    private View view;

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

        model.setMemoryType(view.getTypeComboBox().getModel());
        JOptionPane.showMessageDialog(null, "Details saved : " + "\n" + model.getFirstname()
                + " " + model.getLastname()  + "\n " + model.getMemoryType(), "Info", JOptionPane.INFORMATION_MESSAGE);
    }

    private void closeModal() {
        System.exit(0);
    }
}


