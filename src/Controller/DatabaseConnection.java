/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author matthewkormasela
 */
public class DatabaseConnection {
     private static Connection DatabaseConnection;
     
     public static Connection getDbConnection() {
         if(DatabaseConnection == null){
            try{
                String url;
                url="jdbc:mysql://localhost:1234/dbku";
                String username = "root";
                String password = "root";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                DatabaseConnection=DriverManager.getConnection(url,username,password);
            } catch (SQLException t){
                JOptionPane.showMessageDialog(null, "Failed to create a db connection");
            }
        }
        return DatabaseConnection;
     }
}
