package ie.gmit;

public class Model {

    private String postcode;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String memoryType;

    public Model() {

    }

    public Model(String postcode, String firstname, String lastname, String email, String phone, String memoryType) {
        if(postcode == "" || firstname == "" || lastname == "" || email == "" || phone == "" ) {
            throw new IllegalArgumentException("Field Cannot Be Empty");
        } else {
            this.postcode = postcode;
            this.firstname = firstname;
            this.lastname = lastname;
            this.email = email;
            this.phone = phone;
            this.memoryType = memoryType;
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
    public String getPostcode() {
        return postcode;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getMemoryType() {
        return memoryType;
    }
    public void setMemoryType(String memoryType) {
        this.memoryType = memoryType;
    }
}
