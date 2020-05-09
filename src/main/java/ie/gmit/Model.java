package ie.gmit;

import javax.swing.*;

public class Model {

    private String firstname;
    private String lastname;
    private ComboBoxModel memoryType;

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

    public ComboBoxModel getMemoryType() {
        return memoryType;
    }
    public void setMemoryType(ComboBoxModel memoryType) {
        this.memoryType = memoryType;
    }
}
