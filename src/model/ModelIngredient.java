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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ichinator
 */
public class ModelIngredient {
    
    /**
     * Retourne true si l'ingrédient existe
     * @param nom
     * @return 
     */
    public static boolean verifyIngredient(String nom){
        boolean ingredientInBase = false;
        
        Connection co = Model.startConnection();
        
        try{
            String querySelect = "Select nom FROM Ingredients WHERE nom = ?";
            
            PreparedStatement stmt = co.prepareStatement(querySelect);
            
            stmt.setString(1, nom);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                ingredientInBase = true;
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        Model.closeConnection(co);
        return ingredientInBase;
    }
    
    /**
     * Ajoute un ingrédient
     * @param nom
     * @param categorie
     * @param prix 
     */
    
    public static void addIngredient(String nom, String categorie, int prix){
        if(!verifyIngredient(nom)){
            Connection co = Model.startConnection();
            
            try{
                String queryInsert = "INSERT INTO Ingredients (nom, Categorie_Categorie, prix) VALUES (?,?,?)";
                
                PreparedStatement stmt = co.prepareStatement(queryInsert);
            
                stmt.setString(1, nom);
                stmt.setString(2, categorie);
                stmt.setInt(3, prix);
            
                stmt.executeUpdate();
                
                
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            Model.closeConnection(co);
        }
    }

    /*public static void selectAllIngredients() {
        Connection co = Model.startConnection();
        
        try{
            String querySelect = "SELECT * FROM Ingredients";
        }
    }*/
    
    /**
     * Sélectionne des ingrédients en fonction d'une chaîne de caractères
     * @param nom
     * @return 
     */
    public static ArrayList selectParticularIngredients(String nom){
        
        Connection co = Model.startConnection();
        
        ResultSet rs = null;
        
        ArrayList<String> listeIngredients = new ArrayList<String>();
        
        try{
            String querySelect = "SELECT nom FROM Ingredients WHERE nom LIKE ?";
            
            PreparedStatement stmt = co.prepareStatement(querySelect);
            
            stmt.setString(1, nom+"%");
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                listeIngredients.add(rs.getString(1));                
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        Model.closeConnection(co);
        
       return listeIngredients; 
        
    }
    
    /**
     * Sélectionne l'identifiant d'un ingrédient
     * @param nom
     * @return 
     */

    static int selectId(String nom) {
        
        System.out.println("Select de l'ingrédient");
        
        Connection co = Model.startConnection();
        Integer idIngredient = null;
        try{
            
            System.out.println("try du select de l'ingrédient");
            
            String querySelect = "SELECT idIng FROM Ingredients WHERE nom = ?";
            
            PreparedStatement stmt = co.prepareStatement(querySelect);
            
            stmt.setString(1, nom);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                idIngredient = rs.getInt(1);
            }
        }catch(SQLException ex){
            System.out.println(ex);
        }
        
        return idIngredient;
    }

    public static ResultSet selectAllIngredients() {
        Connection co = Model.startConnection();
        ResultSet rs = null;
        
        try{
            Statement stmt = co.createStatement();
            String selectQuery = "SELECT * FROM Ingredients";
            
            rs = stmt.executeQuery(selectQuery);
            
        }catch (SQLException ex) {
            Logger.getLogger(ModelRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    public static void modifyIngredient(int idIng, String nom, int prix){
        if(verifyIngredient(nom)){
            System.out.println("Passe le if");
            Connection co = Model.startConnection();
            
            try{
                String queryInsert = "UPDATE Ingredients SET nom = ?, prix = ? WHERE idIng = ?";
                
                PreparedStatement stmt = co.prepareStatement(queryInsert);
            
                
                stmt.setString(1, nom);
                stmt.setInt(2, prix);
                stmt.setInt(3, idIng);
            
                stmt.executeUpdate();
                
                
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            Model.closeConnection(co);
        }
    }

    public static void deleteIngredient(int idIng) {
            Connection co = Model.startConnection();
            
            try{
                String queryInsert = "DELETE FROM Ingredients WHERE idIng = ?";
                
                PreparedStatement stmt = co.prepareStatement(queryInsert);
            
                stmt.setInt(1, idIng);
            
                stmt.executeUpdate();
                
                
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            Model.closeConnection(co);
        }
}
