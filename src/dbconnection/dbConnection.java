/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author My HP
 */
public class dbConnection {
   public static Connection conn;
    static{
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.print("Driver loaded");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "OnlineExam" , "student");
            System.out.print("connection established");
            
           JOptionPane.showMessageDialog(null,"connection established");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"connection not established");
        }
    }
    public static Connection getConnection(){
        return conn;
    }
    public static void closeConnection(){
        try
        {
        conn.close();
        JOptionPane.showMessageDialog(null,"connection closed");
        }
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"connection not closed");
        }
    }
   
}
