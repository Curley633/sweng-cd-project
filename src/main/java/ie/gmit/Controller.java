package ie.gmit;

import javax.swing.JOptionPane;

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
        view.getPostcodeTextfield().setText(model.getPostcode());
        view.getEmailTextfield().setText(model.getEmail());
        view.getPhoneTextfield().setText(model.getPhone());
        //view.getTypeComboBox().setText(model.getMemoryType());
    }
    public void initController() {
        view.getSaveDetailsButton().addActionListener(e -> saveDetails());
        view.showDetails().addActionListener(e -> showDetails());
        view.getClose().addActionListener(e -> closeModal());
    }
    private void saveDetails() {
        model.setFirstname(view.getFirstnameTextfield().getText());
        model.setLastname(view.getLastnameTextfield().getText());
        model.setPostcode(view.getPostcodeTextfield().getText());
        model.setEmail(view.getEmailTextfield().getText());
        model.setPhone(view.getPhoneTextfield().getText());
        JOptionPane.showMessageDialog(null, "Details saved : " + "\n" + model.getFirstname()
                + " " + model.getLastname() + "\n " + model.getPostcode()
                + "\n " + model.getEmail() + "\n " + model.getPhone() , "Info", JOptionPane.INFORMATION_MESSAGE);
    }
    private void showDetails() {
        JOptionPane.showMessageDialog(null,  model.getFirstname() + "\n " + model.getLastname()
                + "\n " + model.getPostcode() + "\n " + model.getEmail()
                + "\n " + model.getPhone(), "Info", JOptionPane.INFORMATION_MESSAGE);
    }
    private void closeModal() {
        System.exit(0);
    }
}


