/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesti;

import java.sql.Connection;
import java.util.Date;
import javax.swing.JFrame;

/**
 *
 * @author ichinator
 */
public class Nesti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //model.ModelRecette.createRecipe("truc");
        //model.ModelRecette.readRecipeById(1);
        //model.ModelRecette.readAllRecipes();
        
        //model.ModelVille.addVille("Montpellier", 34090);
        
        //model.ModelVille.voirVille();
        //model.ModelVille.voirUneVille(1);
        
        //model.ModelCategorie.createCategory("Pizzas");
        
        /*
        Date dt = new Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("1995-05-14 10:30:00");
        String currentTime = sdf.format(dt);
        
        model.ModelClient.addClient("Martin", "Bernard", currentTime, "12 rue des oliviers", 1, "abc", "abc@orange.fr");
*/
        View.Main.main(args);
        
        
    }
    
}
