package ie.gmit;

import javax.swing.*;
import java.sql.*;

public class GUI extends JFrame{
    JComboBox jc = new JComboBox();
    JPanel panel = new JPanel();
    Connection conn;
    Statement st;
    ResultSet rs;

    public GUI()
    {
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try{
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/playersdb","root","root*");
            st = conn.createStatement();
            String s = "select * Name from playerstb ";
            rs = st.executeQuery(s);
            while(rs.next())
            {
                jc.addItem(rs.getString(1)+" === "+rs.getString(2));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR");
        }finally{
            try{
                st.close();
                rs.close();
                conn.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "ERROR CLOSE");
            }
        }
        panel.add(jc);
        this.getContentPane().add(panel);
        this.setVisible(true);
    }

    public static void main(String[] args){
        new GUI();
    }
}

/////////////////  END