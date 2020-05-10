package ie.gmit;

import java.sql.*;
import java.util.ArrayList;

public class memoryDatabase {
    private static Connection connection;
    private static PreparedStatement getMemoryTypesStatement;
    private static PreparedStatement productIDStatement;
    private static PreparedStatement decrementQuantityStatement;
    private static PreparedStatement capacityAndPriceStatement;
    private static PreparedStatement brandStatement;

    public static String getConnection() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://206.189.29.193:3306/swt?useSSL=false";
            String username = "memoryDB";
            String password = "KitchenCompanion5*";
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
            return "Connected to Database";

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return "Connected to Database";
    }

    public static ArrayList<String> getMemTypes() {
        try{
            System.out.println("In getMemTypes");
            getConnection();
            System.out.println("After getConnection Called");

            getMemoryTypesStatement = connection.prepareStatement("SELECT memorytype from MemoryStock WHERE quantity > 0");
            ResultSet result = getMemoryTypesStatement.executeQuery();

            ArrayList<String> array = new ArrayList<String>();
            String memoryType;
            while(result.next()){

                memoryType = result.getString("memorytype");
                if(!array.contains(memoryType)){
                    array.add(result.getString("memorytype"));
                }
            }
            System.out.println("All Memory Types have been Selected!");
            System.out.println(array);
            return array;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public static int  getProductID(String memType, int index){
        ArrayList<Integer> array = new ArrayList<Integer>();

        try{
            getConnection();
            productIDStatement = connection.prepareStatement("SELECT productID from MemoryStock WHERE memorytype = '" + memType +"' AND quantity > 0");
            ResultSet result = productIDStatement.executeQuery();
            int ID;
            while(result.next()){
                ID = result.getInt("productID");
                array.add(ID);
            }
        }catch(Exception e) {
            System.out.println(e);
        }
        System.out.println(array.get(index));
        int prodID = array.get(index);
        if(prodID > 0) {
            System.out.println("Prod ID:" + prodID);
            return prodID;
        } else {
            throw new IllegalArgumentException("No product Id for this Item");
        }
    }

    public static int decrementQuantity(int productID) {
        int result = 0;
        try {
            System.out.println("In decrementQuantity");
            getConnection();
            System.out.println("After getConnection Called");

            decrementQuantityStatement = connection.prepareStatement("UPDATE MemoryStock SET quantity = quantity - 1 WHERE productID = '"
                    + productID + "' AND quantity > 0");
            result = decrementQuantityStatement.executeUpdate();

            if(result == 0) {
                System.out.println("No Units Available");
            }

            System.out.println("Decrement Result: " + result);
        } catch (Exception e) {
            System.out.println("Decrement Quantity Error: " + e);
        }
        return result;
    }

    public static ArrayList<String> getCapacityAndPrice(String selectedMemoryType) throws Exception{
        try{
            System.out.println("In getCapacityAndPrice");
            getConnection();
            System.out.println("After getConnection Called");

            capacityAndPriceStatement = connection.prepareStatement("SELECT capacity, price from MemoryStock WHERE memorytype = '"+ selectedMemoryType +"' AND quantity > 0" );

            ResultSet result = capacityAndPriceStatement.executeQuery();

            ArrayList<String> array = new ArrayList<String>();
            String capAndPrice;
            while(result.next()){
                capAndPrice = result.getString("capacity") + "GB €" + result.getString("price");
                array.add(capAndPrice);
            }
            System.out.println(array);
            return array;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
    public static String getBrand(int productID) throws Exception{
        String brand = "";
        try{
            System.out.println("In getBrand");
            getConnection();
            System.out.println("After getConnection Called");

            brandStatement = connection.prepareStatement("SELECT brand from MemoryStock WHERE productID = '"+ productID+"' AND quantity > 0" );

            ResultSet result = brandStatement.executeQuery();

            while(result.next()){

                brand = result.getString("brand");
            }

            System.out.println(brand);
            return brand;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}