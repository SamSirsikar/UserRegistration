/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.PrintWriter;
import java.sql.*;
/**
 *
 * @author samata
 */
class Validate {
    public static boolean checkUser(String email,String pass)
    {
        boolean st= false;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/user_freecharge","root","p");
            PreparedStatement ps= con.prepareStatement("select * from USERS where user_name=? and password=?");
            
            ps.setString(1, email);
            ps.setString(2, pass);
           // out.println("Query: "+ps);
            ResultSet rs= ps.executeQuery();
            st = rs.next();
            
           
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return st;
    }
}