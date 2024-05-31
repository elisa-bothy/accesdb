/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Classe singleton de mariadb
 * 
 * @author Elisa Bothy
 */
public final class MariadbConnection {
    
    private static Connection connection;
    
    private MariadbConnection(){
    }
    
    /**
     * 
     * @return Un singleton de connexion 
     * @throws java.sql.SQLException 
     */
    public static Connection getInstance()throws SQLException{
        if (connection == null){
            String url = "jdbc:mariadb://localhost:3306/example";
            try {
                connection = DriverManager.getConnection(url, "admin", "admin");
            } catch (SQLException ex) {
                Logger.getLogger(MariadbConnection.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }
        }
        return connection;
    }
    
    public static void  closeConnection(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(MariadbConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
