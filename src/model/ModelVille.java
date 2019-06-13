/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ichinator
 */
public class ModelVille {
    
    /**
     * Ajoute une ville
     * @param nom
     * @param CP 
     */
    public static void addVille(String nom, int CP){
        Connection co = Model.startConnection();
        
        try{
            Statement declaration = co.createStatement();
            
            String query = "INSERT INTO Ville (ville,cp) VALUES ('"+nom+"','"+CP+"')";
            
            int executeUpdate = declaration.executeUpdate(query);
            
            
            System.out.println(executeUpdate);
            
            System.out.println(query);
            
        }catch (SQLException ex) {
            Logger.getLogger(ModelRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Sélectionne une ville en fonction de son identifiant
     * @param id 
     */
    public static void voirUneVille(int id){
        Connection co = Model.startConnection();
        
        try{
            Statement stmt = co.createStatement();
            String selectQuery = "SELECT * FROM Ville WHERE idVille = "+id;
            
            ResultSet rs = stmt.executeQuery(selectQuery);
            
            while(rs.next()){
                System.out.println("Id : "+ rs.getInt(1)+" ville : "+rs.getString("ville")+" code postal "+rs.getInt("cp"));
            }
            rs.close();
            Model.closeConnection(co);
        }catch (SQLException ex) {
            Logger.getLogger(ModelRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Sélectionne une liste de ville en fonction de la chaîne de caractères en paramètres
     * @param ville
     * @return 
     */
    public static ArrayList selectVille(String ville) {
        Connection co = Model.startConnection();
        
        ResultSet rs = null;
        
        ArrayList<String> listeVilles = new ArrayList<String>();
        
        try{
            
            String querySelect = "SELECT ville FROM Ville WHERE ville LIKE ?";
            PreparedStatement stmt = co.prepareStatement(querySelect);
            
            stmt.setString(1, ville+"%");
            
            rs = stmt.executeQuery();
            
            
            
            while(rs.next()){
                listeVilles.add(rs.getString(1));                
            }
            rs.close();
            Model.closeConnection(co);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        
        
        
        return listeVilles;
    }
    
    /**
     * Sélectionne l'identifiant d'une ville en fonction de son nom
     * @param ville
     * @return 
     */
    public static int selectOneVille(String ville){
        Connection co = Model.startConnection();
        Integer idVille =null;
        try{
            String querySelect = "SELECT idVille FROM Ville WHERE ville = ?";
            
            PreparedStatement stmt = co.prepareStatement(querySelect);
            
            stmt.setString(1, ville);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                idVille = rs.getInt(1);
            }
            rs.close();
            Model.closeConnection(co);
        }catch(SQLException ex){
            System.out.println(ex);
        }
        
        return idVille;
    }
}
