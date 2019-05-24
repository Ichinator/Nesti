/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ichinator
 */
public class Model {
    public static Connection startConnection(){
        String url = "jdbc:mysql://127.0.0.1/Nesti";
        
        String user = "root";
        
        String password = "140595Bilou1995";
        
        Connection co = null;
        
        try {
            co = DriverManager.getConnection(url, user, password);
            if(!co.isClosed()){
                System.out.println("Connexion ok !");
            }else{
                System.out.println("Pas de connexion !");
            }
        } catch (SQLException ex) {
            System.out.println("Exception "+ex.getMessage());
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return co;
    }
    
    public static void closeConnection(Connection co){
        if(co != null){
            try {
                System.out.println("On ferme la connexion");
                co.close();
            } catch (SQLException ex) {
                Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
