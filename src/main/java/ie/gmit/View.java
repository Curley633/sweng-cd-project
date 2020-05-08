package ie.gmit;

import javafx.scene.control.ComboBox;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JPanel;

public class View extends JPanel implements ActionListener, Runnable {
    // View uses Swing framework to display UI to user
    private JFrame frame;
    private JLabel postcodeLabel;
    private JLabel firstnameLabel;
    private JLabel lastnameLabel;
    private JLabel emailLabel;
    private JLabel phoneLabel;
    private JLabel memoryTypeLabel;
    private JLabel capacityLabel;
    private JComboBox typeComboBox;
    private JComboBox capComboBox;
    private ComboBoxModel[] models;
    private JTextField postcodeTextfield;
    private JTextField firstnameTextfield;
    private JTextField lastnameTextfield;
    private JTextField emailTextfield;
    private JTextField phoneTextfield;
    private JButton saveDetailsButton;
    private JButton show;
    private JButton close;

    ArrayList<String> finalMemoryTypes;
    ArrayList<String> capAndPrice = new ArrayList<String>();

    public View(String title) {
        postcodeTextfield = new JTextField();
        firstnameTextfield = new JTextField();
        lastnameTextfield = new JTextField();
        emailTextfield = new JTextField();
        phoneTextfield = new JTextField();

        final String[] type = new String[1];
        ArrayList<String> memoryTypes = new ArrayList<String>();
        try {
            memoryTypes = memoryDatabase.getMemTypes();
        } catch (Exception e) {
            System.out.println(e);
        }
        typeComboBox = new JComboBox(memoryTypes.toArray());
        finalMemoryTypes = memoryTypes;
        capComboBox = new JComboBox();
        models = new ComboBoxModel[1];
        saveDetailsButton = new JButton("Save Details");
        show = new JButton("Show");
        close = new JButton("Close");


        ArrayList<String> CapAndPrice = new ArrayList<String>();

        models[0] = new DefaultComboBoxModel(
                new String[]{"Select a Memory Type"});


        capComboBox.setModel(models[0]);

        this.add(typeComboBox);
        this.add(capComboBox);
        System.out.println();
        typeComboBox.addActionListener(this);

        capComboBox.addItemListener(
            new ItemListener(){
                    public void itemStateChanged(ItemEvent event){
                        if(event.getStateChange() == ItemEvent.SELECTED){
                            type[0] = (String) capAndPrice.toArray()[capComboBox.getSelectedIndex()];
                            System.out.println(type[0]);
                        }
                }
            }
        );
    }



    public JFrame getFrame() {
        return frame;
    }
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    public JLabel getMemoryTypeLabel() {
        return lastnameLabel;
    }
    public void setMemoryTypeLabel(JLabel memoryTypeLabel) {
        this.memoryTypeLabel = memoryTypeLabel;
    }
    public JComboBox getTypeComboBox() {
        return typeComboBox;
    }
    public void setTypeComboBox(JComboBox typeComboBox) {
        this.typeComboBox = typeComboBox;
    }
    public JComboBox getCapacityComboBox() {
        return capComboBox;
    }
    public void setCapacityComboBox(JComboBox capComboBox) {
        this.capComboBox = capComboBox;
    }
    public JLabel getFirstnameLabel() {
        return firstnameLabel;
    }
    public void setFirstnameLabel(JLabel firstnameLabel) {
        this.firstnameLabel = firstnameLabel;
    }
    public JLabel getLastnameLabel() {
        return lastnameLabel;
    }
    public void setLastnameLabel(JLabel lastnameLabel) {
        this.lastnameLabel = lastnameLabel;
    }
    public JTextField getFirstnameTextfield() {
        return firstnameTextfield;
    }
    public void setFirstnameTextfield(JTextField firstnameTextfield) {
        this.firstnameTextfield = firstnameTextfield;
    }
    public JTextField getLastnameTextfield() {
        return lastnameTextfield;
    }
    public void setLastnameTextfield(JTextField lastnameTextfield) {
        this.lastnameTextfield = lastnameTextfield;
    }
    public JButton getSaveDetailsButton() {
        return saveDetailsButton;
    }
    public void setSaveDetailsButton(JButton saveDetailsButton) {
        this.saveDetailsButton = saveDetailsButton;
    }
    public JButton showDetails() {
        return show;
    }
    public void setShowDetails(JButton details) {
        this.show = details;
    }
    public JButton getClose() {
        return close;
    }
    public void setClose(JButton close) {
        this.close = close;
    }
    public JLabel getPostcodeLabel() {
        return postcodeLabel;
    }
    public void setPostcodeLabel(JLabel postcodeLabel) {
        this.postcodeLabel = postcodeLabel;
    }
    public JLabel getEmailLabel() {
        return emailLabel;
    }
    public void setEmailLabel(JLabel emailLabel) {
        this.emailLabel = emailLabel;
    }
    public JLabel getPhoneLabel() {
        return phoneLabel;
    }
    public void setPhoneLabel(JLabel phoneLabel) {
        this.phoneLabel = phoneLabel;
    }
    public JTextField getPostcodeTextfield() {
        return postcodeTextfield;
    }
    public void setPostcodeTextfield(JTextField postcodeTextfield) {
        this.postcodeTextfield = postcodeTextfield;
    }
    public JTextField getEmailTextfield() {
        return emailTextfield;
    }
    public void setEmailTextfield(JTextField emailTextfield) {
        this.emailTextfield = emailTextfield;
    }
    public JTextField getPhoneTextfield() {
        return phoneTextfield;
    }
    public void setPhoneTextfield(JTextField phoneTextfield) {
        this.phoneTextfield = phoneTextfield;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i = typeComboBox.getSelectedIndex();

        try {
            capAndPrice = memoryDatabase.getCapAndPrice((String) finalMemoryTypes.toArray()[i]);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        models[0] = new DefaultComboBoxModel(capAndPrice.toArray());

        capComboBox.setModel(models[0]);

    }

    @Override
    public void run() {
        frame = new JFrame("Components Order System");
        frame.getContentPane().setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        postcodeLabel = new JLabel("Postcode :");
        firstnameLabel = new JLabel("Firstname :");
        lastnameLabel = new JLabel("Lastname :");
        emailLabel = new JLabel("Email :");
        phoneLabel = new JLabel("Phone :");
        memoryTypeLabel = new JLabel("Memory Type :");
        capacityLabel = new JLabel("Capacity and Price :");

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(memoryTypeLabel)
                        .addComponent(capacityLabel)
                        .addComponent(firstnameLabel)
                        .addComponent(lastnameLabel)
                        .addComponent(postcodeLabel)
                        .addComponent(emailLabel)
                        .addComponent(phoneLabel)
                )


                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(capComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(firstnameTextfield)
                        .addComponent(lastnameTextfield)
                        .addComponent(postcodeTextfield)
                        .addComponent(emailTextfield)
                        .addComponent(phoneTextfield))

                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(show)
                        .addComponent(close)).addComponent(saveDetailsButton));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(memoryTypeLabel)
                        .addComponent(typeComboBox))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(capacityLabel)
                        .addComponent(capComboBox))

                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(firstnameLabel)
                        .addComponent(firstnameTextfield).addComponent(saveDetailsButton).addComponent(show))

                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(lastnameLabel)
                        .addComponent(lastnameTextfield))

                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(postcodeLabel)
                        .addComponent(postcodeTextfield))

                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(emailLabel)
                        .addComponent(emailTextfield))

                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(phoneLabel)
                        .addComponent(phoneTextfield).addComponent(close)));


        layout.linkSize(SwingConstants.HORIZONTAL, saveDetailsButton);
        layout.linkSize(SwingConstants.HORIZONTAL, show, close);
        frame.getContentPane().setLayout(layout);

    }
}