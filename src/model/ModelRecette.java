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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ichinator
 */
public class ModelRecette {
    /**
     * Retourne une recette en fonction de son identifiant
     * @param id 
     */
    public static void readRecipeById(int id){
        Connection co = Model.startConnection();
        try{
            Statement declaration = co.createStatement();
            String selectQuery = "SELECT * FROM Recette WHERE id ="+id;
            ResultSet rs = declaration.executeQuery(selectQuery);
        
            if(rs.next()){
                String nomRs = rs.getString("nom");
                String idRs = rs.getString(1);
                
                System.out.println("Avec l'id "+idRs+" nous avons "+nomRs);
            }
            
            rs.close();
            Model.closeConnection(co);
        }catch (SQLException ex) {
            Logger.getLogger(ModelRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Retourne une liste de recettes
     * @return 
     */
    public static ArrayList<String> readAllRecipes(){
        Connection co = Model.startConnection();
        ResultSet rs;
         ArrayList<String> listeRecettes = new ArrayList<String>();
        try{
            Statement stmt = co.createStatement();
            String selectQuery = "SELECT * FROM Recette";
            
            rs = stmt.executeQuery(selectQuery);
            
            while(rs.next()){
                listeRecettes.add(rs.getString(1));                
            }
            rs.close();
            Model.closeConnection(co);
        }catch (SQLException ex) {
            Logger.getLogger(ModelRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listeRecettes;
    }
    
    public static ResultSet selectAllRecettesJTable(){
        Connection co = Model.startConnection();
        ResultSet rs = null;
        
        try{
            Statement stmt = co.createStatement();
            String selectQuery = "SELECT * FROM Recette";
            
            rs = stmt.executeQuery(selectQuery);
            
        }catch (SQLException ex) {
            Logger.getLogger(ModelRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return rs;
    }

    /**
     * Ajoute une recette
     * @param nom
     * @param description 
     */
    public static void addRecette(String nom, String description) {
        Connection co = Model.startConnection();
        
        try{
            String queryInsert = "INSERT INTO Recette (nom, description) VALUES (?,?)";
            
            PreparedStatement stmt = co.prepareStatement(queryInsert);
            
            stmt.setString(1, nom);
            stmt.setString(2, description);
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    /**
     * Lie une recette avec des ingrédients
     * @param nom
     * @param arrayListIngredients 
     */
    public static void addRecetteIngredients(String nom, ArrayList<String> arrayListIngredients) {
        System.out.println("addRectte");
        
        Connection co = Model.startConnection();
        
        try{
            String queryInsert = "INSERT INTO Ingredients_has_Recette VALUES (?,?)";
            
            Integer idRecette = selectId(nom);
            
            for(int i = 0; i < arrayListIngredients.size(); i++){
                
                Integer idIngredient = model.ModelIngredient.selectId(arrayListIngredients.get(i));
                if(idRecette != null && idIngredient != null){
                    PreparedStatement stmt = co.prepareStatement(queryInsert);
                
                    stmt.setInt(1, idIngredient);
                    stmt.setInt(2, idRecette);

                    stmt.executeUpdate();
                }
            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    /**
     * Sélectionne l'identifiant d'une recette
     * @param nom
     * @return 
     */
    private static int selectId(String nom) {
        
        System.out.println("Select de la recette");
        Connection co = Model.startConnection();
        Integer idRecette = null;
        
        try{
            System.out.println("Try du select de la recette");
            String querySelect = "SELECT idRec FROM Recette WHERE nom = ?";
            
                PreparedStatement stmt = co.prepareStatement(querySelect);
                
                stmt.setString(1, nom);
                
                ResultSet rs = stmt.executeQuery();
                
            while(rs.next()){
                idRecette = rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        Model.closeConnection(co);
        
        return idRecette;
    }
    
    /**
     * Sélectionne toutes les recettes
     * @return 
     */
    public static Map selectAllRecettes() {
        Connection co = Model.startConnection();
        Map mapRecettes = new HashMap();
        
        try{
            String querySelect = "SELECT idRec,nom FROM Recette";
            PreparedStatement stmt = co.prepareStatement(querySelect);
            
            ResultSet rs = stmt.executeQuery();
            
            
            
            while(rs.next()){
                mapRecettes.put(rs.getInt(1), rs.getString(2));                
            }
            rs.close();
            Model.closeConnection(co);
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return mapRecettes;
    }
}
