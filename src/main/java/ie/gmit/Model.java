package ie.gmit;

import javax.swing.*;

public class Model {


    private String postcode;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
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
//    public String getPostcode() {
//        return postcode;
//    }
//    public void setPostcode(String postcode) {
//        this.postcode = postcode;
//    }
//    public String getEmail() {
//        return email;
//    }
//    public void setEmail(String email) {
//        this.email = email;
//    }
//    public String getPhone() {
//        return phone;
//    }
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }

    public ComboBoxModel getMemoryType() {
        return memoryType;
    }
    public void setMemoryType(ComboBoxModel memoryType) {
        this.memoryType = memoryType;
    }
}
