package ie.gmit;

public class AdditionalCosts {

    public AdditionalCosts()
    {

    }

    public int addShippingCost(String country) {
        int shippingCost = 0;
        System.out.println("Country Passed in:" + country);

        if(country.equals("IRE")) {
            shippingCost = 4;
            System.out.println("Shipping cost for " + country + " : €" + shippingCost);

        } else if(country.equals("UK")) {
            shippingCost = 5;
            System.out.println("Shipping cost for " + country + " : €" + shippingCost);

        } else {
            System.out.println(country);
            throw new IllegalArgumentException("IRE or UK ONLY!");
        }
        return shippingCost;
    }

    public double addVAT(double exVAT)
    {
        double incVAT;
        double vatAmount = exVAT * 0.23;

        if(exVAT > 0 ) {
            incVAT = (exVAT + vatAmount);
            System.out.println("Price inc VAT: €" + incVAT);
            return incVAT;
        } else {
            throw new IllegalArgumentException("Price cannot be below 0");
        }
    }

    public int estimatedDeliveryDate(String country)
    {
        int daysFromOrderDate = 0;

        if(country.equals("IRE")) {
            daysFromOrderDate = 2;
            System.out.println("Estimated arrival is " + daysFromOrderDate + " days from now." );

            return daysFromOrderDate;

        } else if (country.equals("UK")) {
            daysFromOrderDate = 5;
            System.out.println("Estimated arrival is " + daysFromOrderDate + " days from now." );

            return daysFromOrderDate;

        } else {
            throw new IllegalArgumentException("Invalid Country input");
        }
    }
}
