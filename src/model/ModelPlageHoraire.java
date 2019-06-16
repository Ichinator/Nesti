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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ichinator
 */
public class ModelPlageHoraire {

    /**
     * Sélectionne toutes les plages horaires
     * @return 
     */
    public static ArrayList<String> selectAllPlageHoraire() {
        Connection co = Model.startConnection();
        
        ArrayList<String> arrayListPlageHoraire = new ArrayList<>();
        
        try{
            String querySelect = "SELECT PlageHor FROM PlageHoraire";
            PreparedStatement stmt = co.prepareStatement(querySelect);
            
            ResultSet rs = stmt.executeQuery();
            
            
            
            while(rs.next()){
                arrayListPlageHoraire.add(rs.getString(1)) ;                
            }
            rs.close();
            Model.closeConnection(co);
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return arrayListPlageHoraire;
    
    }
    
}
