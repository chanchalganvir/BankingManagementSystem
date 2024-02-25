package banking.management.system;


import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    public Conn(){
        try {
            // Load the JDBC driver
             //Class.forName("com.mysql.cj.jdbc.Driver");
             
             // Establish a connection to the MySQL database
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "root");
            
             // Create a statement
            s = c.createStatement();
            
        } catch (Exception e){
            System.out.println(e);
        }
    }
}

