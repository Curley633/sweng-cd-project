package ie.gmit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class memoryDatabase {
    public static Connection getConnection() {
        try{
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://206.189.29.193:3306/swt?useSSL=false";
            String username = "memoryDB";
            String password = "KitchenCompanion5*";

            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connected to Database");
            return conn;
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        return null;
    }

    public static ArrayList<String> getMemTypes() {
        try{
            Connection conn = getConnection();
            PreparedStatement statement = conn.prepareStatement("SELECT memorytype from MemoryStock WHERE quantity > 0");

            ResultSet result = statement.executeQuery();

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
            //String[] memoryTypes = (String[]) array.toArray();
            //System.out.println(memoryTypes);
            return array;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public static int decrementQuantity(String memType, int capacity) {
        int result = 0;
        try {
            Connection conn = getConnection();
            PreparedStatement decrementQuantityStatement = conn.prepareStatement("UPDATE MemoryStock SET quantity = quantity - 1 WHERE memorytype = '"
                    + memType + "' AND capacity = '"+ capacity +"' AND quantity > 0");
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

    public static ArrayList<String> getCapAndPrice(String memtypes) throws Exception{
        try{
            Connection conn = getConnection();
            PreparedStatement capacityAndPricestatement = conn.prepareStatement("SELECT capacity, price from MemoryStock WHERE memorytype = '"+ memtypes +"' AND quantity > 0" );

            ResultSet result = capacityAndPricestatement.executeQuery();

            ArrayList<String> array = new ArrayList<String>();
            String capAndPrice;
            while(result.next()){

                capAndPrice = result.getString("capacity") + "GB €" + result.getString("price");

                array.add(capAndPrice);

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
}
