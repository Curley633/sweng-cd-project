package ie.gmit;

public class Model {

    private String firstname;
    private String lastname;
    private String memoryType;
    private String capacityAndPrice;
    private String brand;
    private String country;
    private int quantity;

    public Model() {

    }

    public Model(String firstname, String lastname, String country) {
        if(firstname.equals("") || lastname.equals("") || country.equals("")){
            throw new IllegalArgumentException("Field Cannot Be Empty");
        } else {
            this.firstname = firstname;
            this.lastname = lastname;
            this.country = country;
        }
    }

    public String getFirstname() {
        return firstname;
    }

    public String setFirstname(String firstname) {
        this.firstname = firstname;
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String setLastname(String lastname) {
        this.lastname = lastname;
        return lastname;
    }
    public int getQuantity() {
        return quantity;
    }

    public int setQuantity(int quantity) {
        this.quantity = quantity;
        return quantity;
    }

    public String getCountry() {
        return country;
    }

    public String setCountry(String country) {
        this.country = country;
        return country;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public String setMemoryType(String memoryType) {
        this.memoryType = memoryType;
        return memoryType;
    }

    public String getCapacityAndPrice() {
        return capacityAndPrice;
    }

    public String  setCapacityAndPrice(String capacityAndPrice) {
        this.capacityAndPrice = capacityAndPrice;
        return  capacityAndPrice;
    }

    public String getBrand() {
        return brand;
    }

    public String setBrand(String brand) {
        this.brand = brand;
        return brand;
    }

}