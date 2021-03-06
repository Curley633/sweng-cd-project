package ie.gmit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class View extends JPanel implements ActionListener, Runnable {
    // View uses Swing framework to display UI to user
    private JFrame frame;

    private JLabel firstnameLabel;
    private JLabel lastnameLabel;
    private JLabel memoryTypeLabel;
    private JLabel capacityLabel;
    private JLabel countryLabel;
    private JLabel detailsLabel;
    private JLabel qtyLabel;

    private JComboBox typeComboBox;
    private JComboBox capComboBox;
    private ComboBoxModel[] models;

    private JTextField firstnameTextfield;
    private JTextField lastnameTextfield;
    private JTextField deliveryCountryTextfield;
    private JTextField quantityTextfield;

    private JButton confirmOrderButton;
    private JButton show;
    private JButton close;

    ArrayList<String> finalMemoryTypes;
    ArrayList<String> capAndPrice = new ArrayList<String>();

    public View() {
        firstnameTextfield = new JTextField();
        lastnameTextfield = new JTextField();
        deliveryCountryTextfield = new JTextField();
        quantityTextfield = new JTextField();

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

        confirmOrderButton = new JButton("Confirm Order");
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
    /*
    public JLabel getFirstnameLabel() {
        return firstnameLabel;
    }
    public void setFirstnameLabel(JLabel firstnameLabel) {
        this.firstnameLabel = firstnameLabel;
    }
    public JLabel getMemoryTypeLabel() {
        return memoryTypeLabel;
    }
    public void setMemoryTypeLabel(JLabel memoryTypeLabel) {
        this.memoryTypeLabel = memoryTypeLabel;
    }
    public JLabel getCountryLabel() {
        return countryLabel;
    }
    public void setCountryLabel(JLabel countryLabel) {
        this.countryLabel = countryLabel;
    }
     */
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

    public JTextField getQuantityTextfield() {
        return quantityTextfield;
    }
    public void setQuantityTextfield(JTextField quantityTextfield) {
        this.lastnameTextfield = lastnameTextfield;
    }

    public JTextField getDeliveryCountryTextfield() {
        return deliveryCountryTextfield;
    }
    public void setDeliveryCountryTextfield(JTextField deliveryCountryTextfield) {
        this.deliveryCountryTextfield = deliveryCountryTextfield;
    }

    public JButton getConfirmOrderButton() {
        return confirmOrderButton;
    }
    public void setConfirmOrderButton(JButton confirmOrderButton) {
        this.confirmOrderButton = confirmOrderButton;
    }

    public JButton getClose() {
        return close;
    }
    public void setClose(JButton close) {
        this.close = close;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i = typeComboBox.getSelectedIndex();

        try {
            capAndPrice = memoryDatabase.getCapacityAndPrice((String) finalMemoryTypes.toArray()[i]);
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
        frame.setSize(600, 230);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        firstnameLabel = new JLabel("Firstname :");
        lastnameLabel = new JLabel("Lastname :");
        countryLabel = new JLabel("Delivery Country :");
        detailsLabel = new JLabel("(IRE & UK only)");
        memoryTypeLabel = new JLabel("Memory Type :");
        capacityLabel = new JLabel("Capacity and Price :");
        qtyLabel = new JLabel("Quantity :");

        GroupLayout layout = new GroupLayout(frame.getContentPane());
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(firstnameLabel)
                        .addComponent(lastnameLabel)
                        .addComponent(countryLabel)
                        .addComponent(memoryTypeLabel)
                        .addComponent(capacityLabel)
                        .addComponent(qtyLabel))

                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(firstnameTextfield)
                        .addComponent(lastnameTextfield)
                        .addComponent(deliveryCountryTextfield)
                        .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(capComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(quantityTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))

                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(detailsLabel)
                        .addComponent(close))
                .addComponent(confirmOrderButton));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(firstnameLabel).addComponent(firstnameTextfield))

                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lastnameLabel).addComponent(lastnameTextfield))

                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(countryLabel).addComponent(deliveryCountryTextfield).addComponent(detailsLabel))

                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(memoryTypeLabel).addComponent(typeComboBox))

                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(capacityLabel).addComponent(capComboBox))

                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(qtyLabel).addComponent(quantityTextfield)
                        .addComponent(close).addComponent(confirmOrderButton))

        );

        layout.linkSize(SwingConstants.HORIZONTAL,close, confirmOrderButton);
        frame.getContentPane().setLayout(layout);

    }
}