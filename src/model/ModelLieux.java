/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ichinator
 */
public class ModelLieux {

    public static Map selectAllLieux() {
        Connection co = Model.startConnection();
        Map mapLieux = new HashMap();
        
        try{
            String querySelect = "SELECT idLieux, adresse, ville FROM Lieux JOIN Ville ON Ville_idVille = idVille";
            PreparedStatement stmt = co.prepareStatement(querySelect);
            
            ResultSet rs = stmt.executeQuery();
            
            
            
            while(rs.next()){
                mapLieux.put(rs.getInt(1), rs.getString(2)+" | "+rs.getString(3));                
            }
            rs.close();
            Model.closeConnection(co);
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return mapLieux;
    }
    
}
