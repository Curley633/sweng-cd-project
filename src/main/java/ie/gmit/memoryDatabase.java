package ie.gmit;

import java.sql.*;
import java.util.ArrayList;

public class memoryDatabase {

    private static Connection connection;
    private static PreparedStatement getMemoryTypesStatement;
    private static PreparedStatement capacityAndPriceStatement;
    private static PreparedStatement decrementQuantityStatement;

    public static String getConnection() {
        try {
            String driver = "com.mysql.jdbc.Driver";
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

            ArrayList<String> array = new ArrayList<>();
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

    public static int decrementQuantity(int productID) {
        int result = 0;
        try {
            getConnection();
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

    public static ArrayList<String> getCapacityAndPrice(String memtypes) {
        ResultSet result;
        ArrayList<String> array = new ArrayList<String>();;
        try{
            getConnection();
            capacityAndPriceStatement = connection.prepareStatement("SELECT capacity, price from MemoryStock WHERE memorytype = '"+ memtypes +"' AND quantity > 0" );

            result = capacityAndPriceStatement.executeQuery();
            String capAndPrice;
            while(result.next()){
                capAndPrice = result.getString("capacity") + "GB €" + result.getString("price");
                array.add(capAndPrice);
            }
            System.out.println("All Memory Types have been Selected!");
            System.out.println(array);
            return array;
        } catch (Exception e){
            System.out.println("ERROR getting Cap and Price:" + e);
        }
        return array;
    }

    public static void makeOrder(String memType, String capacity) {

    }
}
