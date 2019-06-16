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

/**
 *
 * @author ichinator
 */
public class ModelCours {

    /**
     * Ajoute un cours
     * @param idCuisinier
     * @param idRecette
     * @param plageHoraire
     * @param idLieux 
     */
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

    public static ResultSet selectAllCours() {
        Connection co = Model.startConnection();
        ResultSet rs = null;
        try{
            String queryInsert = "SELECT Cours.id, Utilisateurs.nom, Utilisateurs.prenom, ville, jointureLieuxVille.adresse, Cours. PlageHoraire_PlageHor FROM Cours JOIN (SELECT * FROM Lieux JOIN Ville ON Ville_idVille = idVille ) AS jointureLieuxVille ON Lieux_idLieux = idLieux JOIN Utilisateurs ON Utilisateurs.id = Cuisinier_idCuisinier JOIN Recette ON Recette_idRec = idRec";
            
            PreparedStatement stmt = co.prepareStatement(queryInsert);
            rs = stmt.executeQuery();
                    
        }catch(SQLException e){
            System.out.println(e);
        }
        return rs;
    }

    public static void deleteCours(int idCours) {
        Connection co = Model.startConnection();
            
            try{
                String queryInsert = "DELETE FROM Cours WHERE id = ?";
                
                PreparedStatement stmt = co.prepareStatement(queryInsert);
            
                stmt.setInt(1, idCours);
            
                stmt.executeUpdate();
                
                
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            Model.closeConnection(co);
        }
    
}
