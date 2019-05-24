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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ichinator
 */
public class ModelUtilisateurs {

    
    /*public static void createUser(){
        Connection co = Model.startConnection();
        
        try{
            Statement declaration = co.createStatement();
            
            String query = "";
        }
    }*/
    
    
    
    public static void addUserAdmin(String nom, String prenom, String dateNaissance, String adresse, String ville, String password, String mail){
        
        
        Connection co = Model.startConnection();
            try {            
            
            int idVille = ModelVille.selectOneVille(ville);
            
            
            
            //String nom, String prenom, String dateNaissance, String adresse, int idVille, String password, String mail
            
            
            String queryInsert = "INSERT INTO Utilisateurs (nom, prenom, ddn, adresse, Ville_idVille, mdp, mail, isAdmin) VALUES (?,?,?,?,?,?,?,1)";
            
            PreparedStatement stmt = co.prepareStatement(queryInsert);
            
            stmt.setString(1, nom);
            stmt.setString(2, prenom);
            stmt.setString(3, dateNaissance);
            stmt.setString(4, adresse);
            stmt.setInt(5, idVille);
            stmt.setString(6, password);
            stmt.setString(7, mail);
           
            stmt.executeUpdate();
            
            Model.closeConnection(co);
            
            }catch (SQLException ex) {
                Logger.getLogger(ModelRecette.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }
    
    public static void updateUserToAdmin(String nom, String prenom){
        Connection co = Model.startConnection();
        
        try{
                
                
                String querySelect = "UPDATE UPDATE table SET isAdmin = 1 WHERE nom = ? AND prenom = ? AND isAdmin = 0";
            
                PreparedStatement stmt = co.prepareStatement(querySelect);
                
                stmt.setString(1, nom);
                stmt.setString(2, prenom);
                
                stmt.executeUpdate();
                
                Model.closeConnection(co);
                
            }catch(SQLException ex){
                System.out.println(ex);
            }
    }
    
    
    public static boolean verifyUser(String nom, String prenom){
        boolean userInBase = false;
        Connection co = Model.startConnection();
        
        try{
                
                
                String querySelect = "SELECT nom FROM Utilisateurs WHERE nom=? AND prenom=?";
            
                PreparedStatement stmt = co.prepareStatement(querySelect);
                
                stmt.setString(1, nom);
                stmt.setString(2, prenom);
                
                ResultSet rs = stmt.executeQuery();
                
                while(rs.next()){
                    userInBase = true;
                }
                
                Model.closeConnection(co);
                
            }catch(SQLException ex){
                System.out.println(ex);
            }
        
        return userInBase;
    }
    
    
    
    public static boolean verifyAdmin(String nom, String prenom, String password) {
        
        boolean returnType = false;

        Connection co = Model.startConnection();
        try {
            System.out.println("Le statement est passé");
            String query = "SELECT nom, prenom, mdp FROM Utilisateurs WHERE nom = (?) AND prenom = (?) AND mdp = (?) AND isAdmin = 1";  
            
            PreparedStatement declaration = co.prepareStatement(query);
            
            declaration.setString(1, nom);
            declaration.setString(2, prenom);
            declaration.setString(3, password);
            
            System.out.println("La requête entrée est : " + declaration);
            
            ResultSet rs = declaration.executeQuery();
            
            while(rs.next()){
                returnType = true;
            }
            
            Model.closeConnection(co);
        } catch (SQLException ex) {
            System.out.println(ex);

        }
        
        return returnType;
    }
    
    public static ResultSet selectAllUser() {
        
        Connection co = Model.startConnection();
        ResultSet rs = null;
        
        try{
            String querySelect = "SELECT * FROM Utilisateurs JOIN Ville ON idVille = Ville_idVille";  
        
            PreparedStatement stmt = co.prepareStatement(querySelect);
        
            rs = stmt.executeQuery(querySelect);
        
        
        }catch(SQLException ex){
            System.out.println(ex);
        }
       return rs;         
    }
    
    
    public static ResultSet selectParticularUsersWithConditions(String nom, String prenom, Boolean isClient, Boolean isCuisinier, Boolean isAdmin){
       Connection co = Model.startConnection();
        ResultSet rs = null;
        try{
            //SELECT * FROM Utilisateurs JOIN Ville ON idVille = Ville_idVille WHERE nom LIKE "%D%" AND prenom LIKE "%A%";

           
            String querySelect = "SELECT * FROM Utilisateurs JOIN Ville ON idVille = Ville_idVille WHERE nom LIKE ? AND prenom LIKE ? :conditionClient";
            
            
            
            // Si toutes les checkboxs sont décochées, on fait une recherche sans que le rôle n'entre en compte
            if(isClient == true || isCuisinier == true || isAdmin == true){
                if(isClient){
                querySelect+=" AND isClient = 1";
                
                System.out.println("1 true");
                }else{
                   querySelect+=" AND isClient = 0"; 

                    System.out.println("1 false");
                }

                if(isCuisinier){
                    querySelect+=" AND isCuisinier = 1";

                    System.out.println("2 true");
                }else{
                    querySelect+=" AND isCuisinier = 0";

                    System.out.println("2 false");
                }

                if(isAdmin){
                    querySelect+=" AND isAdmin = 1";

                    System.out.println("3 true");
                }else{
                    querySelect+=" AND isAdmin = 0";

                    System.out.println("3 false");
                }
            }
            
            System.out.println(querySelect);
        
            PreparedStatement stmt = co.prepareStatement(querySelect);
               stmt.setString(1, "%"+nom+"%");
               stmt.setString(2, "%"+prenom+"%");
               
            rs = stmt.executeQuery();
        
        
        }catch(SQLException ex){
            System.out.println(ex);
        }
       return rs;  
       
    }
}
