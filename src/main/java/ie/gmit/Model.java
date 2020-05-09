package ie.gmit;

import javax.swing.*;

public class Model {

    private String firstname;
    private String lastname;
    private String brand;
    private String memoryType;
    private String capacityAndPrice;

    public Model() {

    }

    public Model(String firstname, String lastname) {
        if(firstname == "" || lastname == "" ) {
            throw new IllegalArgumentException("Field Cannot Be Empty");
        } else {
            this.firstname = firstname;
            this.lastname = lastname;
        }
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getMemoryType() {
        return memoryType;
    }

    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }
    public String getCapacityAndPrice() {
        return capacityAndPrice;
    }

    public void setCapacityAndPrice(String capacityAndPrice) {
        this.capacityAndPrice = capacityAndPrice;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


}
