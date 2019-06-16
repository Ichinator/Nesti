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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ichinator
 */
public class ModelCategorie {
    
    /**
     * Prend en paramètre le nom et la description et crée une catégorie. Avant cela vérifie que la catégorie n'existe pas
     * @param nomCategorie
     * @param descriptionCategory 
     */
    public static void createCategory(String nomCategorie, String descriptionCategory){
        Connection co = Model.startConnection();
        try{
            // Selection pour vérifier que la catégorie n'existe pas
            String querySelect = "SELECT * FROM Categorie WHERE nomCategorie = (?)";
            
            PreparedStatement stmt = co.prepareStatement(querySelect);
            
            stmt.setString(1, nomCategorie);
            
            ResultSet rs = stmt.executeQuery();
            
            // Si le résultat est null alors rs.next() renvoie false, du coup on peu insérer
            while(!rs.next()){
                try {
                    
                    String queryInsert;
                    queryInsert = "INSERT INTO Categorie (nomCategorie, description) VALUES(?,?)";
                    
                    PreparedStatement declaration = co.prepareStatement(queryInsert);
            
                    declaration.setString(1, nomCategorie);
                    declaration.setString(2, descriptionCategory);
                    
                    int executeUpdate = declaration.executeUpdate();
            
            
                    System.out.println(executeUpdate);
            
                    System.out.println(queryInsert);
            
                    // Break car sinon plusieurs insertions à cause du while qui reste faux
                    break;
                } catch (SQLException ex) {
                    Logger.getLogger(ModelRecette.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        catch (SQLException ex) {
                    Logger.getLogger(ModelRecette.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        
        Model.closeConnection(co);
    }
    
    /**
     * Sélectionne toutes les catégories
     * @return 
     */
    public static ResultSet selectAllCategory(){
    
        Connection co = Model.startConnection();
        ResultSet rs = null;
        
        try{
            String querySelect = "SELECT nomCategorie FROM Categorie";
            PreparedStatement stmt = co.prepareStatement(querySelect);
            rs = stmt.executeQuery();
            return rs;
        }catch(SQLException ex){
            System.out.println(ex);
        }
        
        return rs;
    }
    
    /**
     * Sélectionne les catégories contenant la  chaîne de caractères en paramètre. Retourne un ResultSet
     * @param searchCategory
     * @return 
     */

    public static ResultSet selectOneCategory(String searchCategory) {
        Connection co = Model.startConnection();
        ResultSet rs = null;
        
        try{
            String querySelect = "SELECT nomCategorie FROM Categorie WHERE nomCategorie LIKE ?";
            PreparedStatement stmt = co.prepareStatement(querySelect);
            stmt.setString(1, "%"+searchCategory+"%");
            rs = stmt.executeQuery();
        }catch(SQLException ex){
            System.out.println(ex);
        }
        
        return rs;
    }
    
    /**
     * Sélectionne les catégories contenant la  chaîne de caractères en paramètre. Retourne un ArrayList
     * @param categorie
     * @return 
     */
    public static ArrayList selectCategorie(String categorie) {
        Connection co = Model.startConnection();
        
        ResultSet rs = null;
        
        ArrayList<String> listesCategories = new ArrayList<String>();
        
        try{
            
            String querySelect = "SELECT nomCategorie FROM Categorie WHERE nomCategorie LIKE ?";
            PreparedStatement stmt = co.prepareStatement(querySelect);
            
            stmt.setString(1, categorie+"%");
            
            rs = stmt.executeQuery();
            
            
            
            while(rs.next()){
                listesCategories.add(rs.getString(1));                
            }
            rs.close();
            Model.closeConnection(co);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        
        
        
        return listesCategories;
    }

    public static void updateCategory(String nomCategory, String descriptionCategory) {
        Connection co = Model.startConnection();
        
        
        try{
            String queryUpdate = "UPDATE Categorie SET description = ? WHERE nomCategorie = ?";
            
            PreparedStatement stmt = co.prepareStatement(queryUpdate);
            
            stmt.setString(1, descriptionCategory);
            stmt.setString(2, nomCategory);
            
                    
            stmt.executeUpdate();
            
            //Model.closeConnection(co);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void deleteCategory(String nomCategory) {
        Connection co = Model.startConnection();
        
        try{
            String queryUpdate = "DELETE FROM Categorie WHERE nomCategorie = ?";
            
            PreparedStatement stmt = co.prepareStatement(queryUpdate);
            stmt.setString(1, nomCategory);
            
                    
            stmt.executeUpdate();
            
            //Model.closeConnection(co);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
