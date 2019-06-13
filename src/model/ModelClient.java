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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ichinator
 */
public class ModelClient {
    
    /**
     * Ajoute un client
     * @param nom
     * @param prenom
     * @param dateNaissance
     * @param adresse
     * @param idVille
     * @param password
     * @param mail 
     */
    public static void addClient(String nom, String prenom, String dateNaissance, String adresse, int idVille, String password, String mail){
        Connection co = Model.startConnection();
        
        try {
            Statement declaration = co.createStatement();
            
            
            
            String query = "INSERT INTO Utilisateurs (nom, prenom, ddn, adresse, Ville_idVille, mdp, mail, isClient) VALUES ('"+nom+"','"+prenom+"','"+dateNaissance+"','"+adresse+"','"+idVille+"','"+password+"','"+mail+"', 1)";
            
            int executeUpdate = declaration.executeUpdate(query);
            
            
            System.out.println(executeUpdate);
            
            System.out.println(query);
        }catch (SQLException ex) {
            Logger.getLogger(ModelRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Permet de voir tous les clients
     */
    public static void voirClient(){
        Connection co = Model.startConnection();
        
        try{
            Statement stmt = co.createStatement();
            String selectQuery = "SELECT * FROM Client";
            
            ResultSet rs = stmt.executeQuery(selectQuery);
            
            while(rs.next()){
                System.out.println("Id : "+ rs.getInt(1)+" nom : "+rs.getString("nom")+" prénom : "+rs.getString("prenom")+" date de naissance :"+rs.getDate("ddn")+" adresse "+rs.getString("adresse")+" mot de passe : "+rs.getString("mdp")+" mail : "+rs.getString("mail"));
                System.out.println("On affiche la ville !");
                ModelVille.voirUneVille(rs.getInt("ville_idVille"));
            }
            rs.close();
            Model.closeConnection(co);
        }catch (SQLException ex) {
            Logger.getLogger(ModelRecette.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
