/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ichinator
 */
public class ModelCours {

    public static void addCours(int idCuisinier, int idRecette, String plageHoraire, int idLieux) {
        
        Connection co = Model.startConnection();
        
        try{
            String queryInsert = "INSERT INTO Cours (Recette_idRec, Cuisinier_idCuisinier, PlageHoraire_PlageHor, Lieux_idLieux) VALUES (?, ?, ?, ?)";
            
            PreparedStatement stmt = co.prepareStatement(queryInsert);
            
            stmt.setInt(1, idRecette);
            stmt.setInt(2, idCuisinier);
            stmt.setString(3, plageHoraire);
            stmt.setInt(4, idLieux);
            
            stmt.executeUpdate();
                    
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
}
