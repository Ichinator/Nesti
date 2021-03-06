/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import javax.swing.BoxLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ichinator
 */
public class Main extends javax.swing.JFrame {
    
    ArrayList<String> arrayListIngredients = new ArrayList<>();
    
    ArrayList<String> arrayListePlageHoraire = new ArrayList<>();
    Map mapCuisiniers = new HashMap();
    Map mapRecettes = new HashMap();
    Map mapLieux = new HashMap();
    


    /**
     * Creates new form Main
     */
    public Main() {
        
        

        initComponents();

        fillJTableCategory();

        fillJTableUsers();
        
        fillJTableRecettes();
        
        fillJTableIngredients();
        
        fillJTableCours();

        jComboBoxAddVilleUser.removeAllItems();
        jComboBoxChooseCategorieIngredient.removeAllItems();
        jComboBoxListIngredients.removeAllItems();
        
        
        
        
        fillJComboBoxAddCoursCuisinier();
        fillJComboBoxAddCoursRecette();
        fillJComboBoxAddCoursPlageHoraire();
        fillJComboBoxAddCoursLieux();
        
                
        
        
        //model.ModelIngredient.selectAllIngredients();

    }

    /**
     * Récupère un ResultSet retourné par selectAllCategory() et remplit jTableCategory avec celui-ci.
     */
    private void fillJTableCategory() {
        // On remplit jTableCategory avec le ResultSet
        ResultSet result = model.ModelCategorie.selectAllCategory();
        jTableCategory.setModel(DbUtils.resultSetToTableModel(result));
    }

    /**
     * Récupère un ResultSet retourné par selectAllUsers() et remplit jTableUsers avec celui-ci.
     */
    private void fillJTableUsers() {
        // On remplit jTableCategory avec le ResultSet
        ResultSet resultAllUsers = model.ModelUtilisateurs.selectAllUser();
        jTableUsers.setModel(DbUtils.resultSetToTableModel(resultAllUsers));
    }
    
    private void fillJTableRecettes() {
        // On remplit jTableRecettes avec le ResultSet
        ResultSet result = model.ModelRecette.selectAllRecettesJTable();
        jTableRecettes.setModel(DbUtils.resultSetToTableModel(result));
    }
    
    private void fillJTableIngredients() {
        // On remplit jTableRecettes avec le ResultSet
        ResultSet result = model.ModelIngredient.selectAllIngredients();
        jTableIngredients.setModel(DbUtils.resultSetToTableModel(result));
    }
    
    private void fillJTableCours(){
        ResultSet result = model.ModelCours.selectAllCours();
        jTableCours.setModel(DbUtils.resultSetToTableModel(result));
    }
    
    /**
     * Remplit la jComboBoxAddCoursCuisinier
     */
    
    private void fillJComboBoxAddCoursCuisinier(){
        jComboBoxAddCoursCuisinier.removeAllItems();
         
        this.mapCuisiniers = model.ModelUtilisateurs.selectAllCuisiniers();
        this.mapCuisiniers.forEach( (k,v) -> jComboBoxAddCoursCuisinier.addItem(v.toString()));
    }
    
    /**
     * Remplit la jComboBoxAddCoursRecette
     */
    private void fillJComboBoxAddCoursRecette(){
        jComboBoxAddCoursRecette.removeAllItems();
         
        this.mapRecettes = model.ModelRecette.selectAllRecettes();
        this.mapRecettes.forEach( (k,v) -> jComboBoxAddCoursRecette.addItem(v.toString()));
        
    }
    
    /**
     * Remplit la jComboBoxAddCoursPlageHoraire
     */
    private void fillJComboBoxAddCoursPlageHoraire(){
        jComboBoxAddCoursPlageHoraire.removeAllItems();
         
        this.arrayListePlageHoraire = model.ModelPlageHoraire.selectAllPlageHoraire();
        this.arrayListePlageHoraire.forEach( (n) -> jComboBoxAddCoursPlageHoraire.addItem(n));
        
    }
    
    /**
     * Remplit la jComboBoxAddCoursLieux
     */
    private void fillJComboBoxAddCoursLieux(){
        jComboBoxAddCoursLieux.removeAllItems();
        this.mapLieux = model.ModelLieux.selectAllLieux();
        this.mapLieux.forEach((k,v)->jComboBoxAddCoursLieux.addItem(v.toString()));
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jTabbedPanelCours = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButtonAddCategory = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaAddCategory = new javax.swing.JTextArea();
        jTextFieldAddCategory = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCategory = new javax.swing.JTable();
        jTextFieldSearchCategory = new javax.swing.JTextField();
        jButtonSearchCategory = new javax.swing.JButton();
        jButtonModifyCategory = new javax.swing.JButton();
        jButtonDeleteCategory = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabelNomIngrédient = new javax.swing.JLabel();
        jButtonAddIngredient = new javax.swing.JButton();
        jTextFieldAddIngrédient = new javax.swing.JTextField();
        jLabelChooseCategorieIngredient = new javax.swing.JLabel();
        jComboBoxChooseCategorieIngredient = new javax.swing.JComboBox<>();
        jTextFieldChooseCategorieIngredient = new javax.swing.JTextField();
        jLabelPrixIngredient = new javax.swing.JLabel();
        jTextFieldPrixIngredient = new javax.swing.JTextField();
        jButtonModifyIngredient = new javax.swing.JButton();
        jButtonDeleteIngredient = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableIngredients = new javax.swing.JTable();
        jTextFieldAddIngredientId = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jTextFieldAddVilleUser = new javax.swing.JTextField();
        jComboBoxAddVilleUser = new javax.swing.JComboBox<>();
        jButtonAddAdmin = new javax.swing.JButton();
        jLabelAddAdminNom = new javax.swing.JLabel();
        jLabelAddAdminPrenom = new javax.swing.JLabel();
        jTextFieldAddAdminPrenom = new javax.swing.JTextField();
        jTextFieldAddAdminNom = new javax.swing.JTextField();
        jTextFieldAddAdminJour = new javax.swing.JTextField();
        jTextFieldAddAdminMois = new javax.swing.JTextField();
        jTextFieldAddAdminAnnee = new javax.swing.JTextField();
        jLabelAddAdminDateNaissance = new javax.swing.JLabel();
        jLabelAddAdminMail = new javax.swing.JLabel();
        jTextFieldAddAdminMail = new javax.swing.JTextField();
        jLabelAddAdminPassword = new javax.swing.JLabel();
        jPasswordFieldAddAdminPassword = new javax.swing.JPasswordField();
        jPasswordFieldAddAdminPasswordConfirm = new javax.swing.JPasswordField();
        jLabelAddAdminPasswordConfirm = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabelAddAdminAdresse = new javax.swing.JLabel();
        jTextFieldAddAdminAdresse = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButtonSearchUsers = new javax.swing.JButton();
        jTextFieldSearchUsers = new javax.swing.JTextField();
        jCheckBoxAdmin = new javax.swing.JCheckBox();
        jCheckBoxCuisinier = new javax.swing.JCheckBox();
        jCheckBoxClient = new javax.swing.JCheckBox();
        jCheckBoxAll = new javax.swing.JCheckBox();
        jCheckBoxNoOne = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableUsers = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jButtonDeleteUtilisateurs = new javax.swing.JButton();
        jTextFieldDeleteUtilisateurs = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabelRecetteInCours = new javax.swing.JLabel();
        jLabelCuisinierInCours = new javax.swing.JLabel();
        jLabelLieuxInCours = new javax.swing.JLabel();
        jLabelPlageHoraireInCours = new javax.swing.JLabel();
        jButtonAddCours = new javax.swing.JButton();
        jComboBoxAddCoursRecette = new javax.swing.JComboBox<>();
        jComboBoxAddCoursPlageHoraire = new javax.swing.JComboBox<>();
        jComboBoxAddCoursCuisinier = new javax.swing.JComboBox<>();
        jComboBoxAddCoursLieux = new javax.swing.JComboBox<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableCours = new javax.swing.JTable();
        jButtonModifyCours = new javax.swing.JButton();
        jButtonDeleteCours = new javax.swing.JButton();
        jTextFieldCours = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jTextFieldAddRecette = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextAreaAddRecette = new javax.swing.JTextArea();
        jButtonAddRecette = new javax.swing.JButton();
        jTextFieldListIngredients = new javax.swing.JTextField();
        jComboBoxListIngredients = new javax.swing.JComboBox<>();
        jButtonAddIngredientToRecette = new javax.swing.JButton();
        jLabelListIngredients = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableRecettes = new javax.swing.JTable();

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1583, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 754, Short.MAX_VALUE)
        );

        jTabbedPanelCours.addTab("Accueil", jPanel1);

        jButtonAddCategory.setText("Ajouter la catégorie");
        jButtonAddCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddCategoryActionPerformed(evt);
            }
        });

        jTextAreaAddCategory.setColumns(20);
        jTextAreaAddCategory.setRows(5);
        jScrollPane1.setViewportView(jTextAreaAddCategory);

        jTableCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTableCategory);

        jButtonSearchCategory.setText("Chercher");
        jButtonSearchCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchCategoryActionPerformed(evt);
            }
        });

        jButtonModifyCategory.setText("Modifier");
        jButtonModifyCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifyCategoryActionPerformed(evt);
            }
        });

        jButtonDeleteCategory.setText("Supprimer");
        jButtonDeleteCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jTextFieldSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jButtonSearchCategory)
                .addGap(189, 1209, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1032, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButtonModifyCategory)
                        .addGap(51, 51, 51)
                        .addComponent(jButtonAddCategory)
                        .addGap(33, 33, 33)
                        .addComponent(jButtonDeleteCategory)))
                .addGap(137, 137, 137))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearchCategory))
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jTextFieldAddCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddCategory)
                    .addComponent(jButtonModifyCategory)
                    .addComponent(jButtonDeleteCategory))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPanelCours.addTab("Les catégories", jPanel4);

        jLabelNomIngrédient.setText("Nom de l'ingrédient");

        jButtonAddIngredient.setText("Ajouter à la base");
        jButtonAddIngredient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddIngredientActionPerformed(evt);
            }
        });

        jLabelChooseCategorieIngredient.setText("Catégorie de l'ingrédient");

        jComboBoxChooseCategorieIngredient.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextFieldChooseCategorieIngredient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldChooseCategorieIngredientActionPerformed(evt);
            }
        });
        jTextFieldChooseCategorieIngredient.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldChooseCategorieIngredientKeyPressed(evt);
            }
        });

        jLabelPrixIngredient.setText("Prix");

        jButtonModifyIngredient.setText("Modifier l'ingrédient");
        jButtonModifyIngredient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifyIngredientActionPerformed(evt);
            }
        });

        jButtonDeleteIngredient.setText("Supprimer l'ingrédient");
        jButtonDeleteIngredient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteIngredientActionPerformed(evt);
            }
        });

        jTableIngredients.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(jTableIngredients);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabelPrixIngredient, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelNomIngrédient, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabelChooseCategorieIngredient)
                                .addGap(43, 43, 43)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonAddIngredient)
                                    .addComponent(jTextFieldChooseCategorieIngredient, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldAddIngrédient)
                            .addComponent(jComboBoxChooseCategorieIngredient, 0, 143, Short.MAX_VALUE)
                            .addComponent(jTextFieldPrixIngredient)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonModifyIngredient)
                            .addComponent(jButtonDeleteIngredient))
                        .addGap(75, 75, 75)
                        .addComponent(jTextFieldAddIngredientId, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAddIngrédient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNomIngrédient))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrixIngredient)
                    .addComponent(jTextFieldPrixIngredient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelChooseCategorieIngredient)
                    .addComponent(jComboBoxChooseCategorieIngredient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldChooseCategorieIngredient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jButtonAddIngredient)
                .addGap(67, 67, 67)
                .addComponent(jButtonModifyIngredient)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAddIngredientId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDeleteIngredient))
                .addGap(146, 146, 146))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPanelCours.addTab("Les ingrédients", jPanel6);

        jTextFieldAddVilleUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAddVilleUserActionPerformed(evt);
            }
        });
        jTextFieldAddVilleUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldAddVilleUserKeyPressed(evt);
            }
        });

        jComboBoxAddVilleUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonAddAdmin.setText("Créer l'administrateur");
        jButtonAddAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddAdminActionPerformed(evt);
            }
        });

        jLabelAddAdminNom.setText("Nom");

        jLabelAddAdminPrenom.setText("Prenom");

        jTextFieldAddAdminJour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAddAdminJourActionPerformed(evt);
            }
        });

        jLabelAddAdminDateNaissance.setText("Date de naissance");

        jLabelAddAdminMail.setText("Mail");

        jLabelAddAdminPassword.setText("Mot de passe");

        jLabelAddAdminPasswordConfirm.setText("Confirmer mot de passe");

        jLabel1.setText("Les informations suivantes ne seront insérées que si l'utilisateur n'est pas dans la base de données mais elles sont tout de même requises");

        jLabelAddAdminAdresse.setText("Adresse");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelAddAdminDateNaissance)
                            .addComponent(jLabelAddAdminPassword)
                            .addComponent(jLabelAddAdminAdresse))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPasswordFieldAddAdminPassword)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jTextFieldAddAdminJour, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldAddAdminMois, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldAddAdminAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(108, 108, 108)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelAddAdminMail)
                                    .addComponent(jLabelAddAdminPasswordConfirm))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldAddAdminMail, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPasswordFieldAddAdminPasswordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextFieldAddAdminAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(jLabelAddAdminNom, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jTextFieldAddAdminNom, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(jLabelAddAdminPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(jTextFieldAddAdminPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(jLabel1))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(584, 584, 584)
                        .addComponent(jButtonAddAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(396, 396, 396)
                        .addComponent(jTextFieldAddVilleUser, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(202, 202, 202)
                        .addComponent(jComboBoxAddVilleUser, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(466, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAddAdminNom)
                    .addComponent(jLabelAddAdminPrenom)
                    .addComponent(jTextFieldAddAdminPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAddAdminNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAddAdminJour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAddAdminMois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAddAdminAnnee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddAdminDateNaissance)
                    .addComponent(jLabelAddAdminMail)
                    .addComponent(jTextFieldAddAdminMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAddAdminPassword)
                    .addComponent(jPasswordFieldAddAdminPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordFieldAddAdminPasswordConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAddAdminPasswordConfirm))
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelAddAdminAdresse)
                    .addComponent(jTextFieldAddAdminAdresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldAddVilleUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAddVilleUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jButtonAddAdmin)
                .addGap(118, 118, 118))
        );

        jTabbedPanelCours.addTab("Créer un administrateur", jPanel5);

        jButton3.setText("jButton3");

        jButtonSearchUsers.setText("rechercher");
        jButtonSearchUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchUsersActionPerformed(evt);
            }
        });

        jCheckBoxAdmin.setText("administrateurs");

        jCheckBoxCuisinier.setText("cuisiniers");

        jCheckBoxClient.setText("clients");

        jCheckBoxAll.setText("tout cocher");
        jCheckBoxAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxAllActionPerformed(evt);
            }
        });

        jCheckBoxNoOne.setText("tout décocher");
        jCheckBoxNoOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxNoOneActionPerformed(evt);
            }
        });

        jTableUsers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTableUsers);

        jButtonDeleteUtilisateurs.setText("Supprimer");
        jButtonDeleteUtilisateurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteUtilisateursActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1267, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldSearchUsers, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(jTextField1))
                        .addGap(103, 103, 103))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSearchUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCheckBoxAdmin)
                                    .addComponent(jCheckBoxCuisinier)
                                    .addComponent(jCheckBoxClient)
                                    .addComponent(jCheckBoxAll)
                                    .addComponent(jCheckBoxNoOne)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addComponent(jButtonDeleteUtilisateurs)
                                        .addGap(75, 75, 75)
                                        .addComponent(jTextFieldDeleteUtilisateurs, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jTextFieldSearchUsers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButtonSearchUsers)
                .addGap(22, 22, 22)
                .addComponent(jCheckBoxAdmin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxCuisinier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxClient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxNoOne)
                .addGap(97, 97, 97)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDeleteUtilisateurs)
                    .addComponent(jTextFieldDeleteUtilisateurs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
        );

        jTabbedPanelCours.addTab("Les utilisateurs", jPanel2);

        jLabelRecetteInCours.setText("Recette");

        jLabelCuisinierInCours.setText("Cuisinier");

        jLabelLieuxInCours.setText("Lieux");

        jLabelPlageHoraireInCours.setText("Plage horaire");

        jButtonAddCours.setText("Ajouter le cours");
        jButtonAddCours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddCoursActionPerformed(evt);
            }
        });

        jComboBoxAddCoursRecette.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxAddCoursPlageHoraire.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxAddCoursCuisinier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxAddCoursLieux.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTableCours.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(jTableCours);

        jButtonModifyCours.setText("Modifier");

        jButtonDeleteCours.setText("Supprimer");
        jButtonDeleteCours.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteCoursActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelPlageHoraireInCours)
                                    .addComponent(jLabelRecetteInCours))
                                .addGap(61, 61, 61)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBoxAddCoursRecette, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxAddCoursPlageHoraire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(137, 137, 137)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelCuisinierInCours)
                                    .addComponent(jLabelLieuxInCours))
                                .addGap(61, 61, 61)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxAddCoursCuisinier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxAddCoursLieux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(305, 305, 305)
                                .addComponent(jButtonAddCours)))
                        .addGap(133, 133, 133)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonModifyCours)
                            .addComponent(jButtonDeleteCours))
                        .addGap(53, 53, 53)
                        .addComponent(jTextFieldCours, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(190, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRecetteInCours)
                    .addComponent(jLabelCuisinierInCours)
                    .addComponent(jComboBoxAddCoursRecette, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxAddCoursCuisinier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelLieuxInCours)
                            .addComponent(jLabelPlageHoraireInCours)
                            .addComponent(jComboBoxAddCoursPlageHoraire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jComboBoxAddCoursLieux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(113, 113, 113)
                .addComponent(jButtonAddCours)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonModifyCours)
                    .addComponent(jTextFieldCours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonDeleteCours)
                .addGap(114, 114, 114))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPanelCours.addTab("Cours", jPanel8);

        jTextAreaAddRecette.setColumns(20);
        jTextAreaAddRecette.setRows(5);
        jScrollPane4.setViewportView(jTextAreaAddRecette);

        jButtonAddRecette.setText("Ajouter la recette");
        jButtonAddRecette.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddRecetteActionPerformed(evt);
            }
        });

        jTextFieldListIngredients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldListIngredientsActionPerformed(evt);
            }
        });
        jTextFieldListIngredients.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldListIngredientsKeyPressed(evt);
            }
        });

        jComboBoxListIngredients.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonAddIngredientToRecette.setText("Ajouter l'ingrédient");
        jButtonAddIngredientToRecette.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddIngredientToRecetteActionPerformed(evt);
            }
        });

        jTableRecettes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTableRecettes);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(263, 263, 263)
                        .addComponent(jTextFieldAddRecette, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jButtonAddRecette, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(512, 512, 512)
                                        .addComponent(jButtonAddIngredientToRecette, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jTextFieldListIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(334, 334, 334)
                                        .addComponent(jComboBoxListIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1078, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelListIngredients, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jTextFieldAddRecette, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelListIngredients, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldListIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxListIngredients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAddRecette, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAddIngredientToRecette, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPanelCours.addTab("Les recettes", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPanelCours)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPanelCours)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Récupère les identifiants du cuisinier, de la recette et du lieux en utilisant getKeyByValue() et appelle addCours()
     * @param evt 
     */
    private void jButtonAddCoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddCoursActionPerformed

        int idCuisinier = getKeyByValue(mapCuisiniers, jComboBoxAddCoursCuisinier.getSelectedItem());
        int idRecette = getKeyByValue(mapRecettes, jComboBoxAddCoursRecette.getSelectedItem());
        String plageHoraire = jComboBoxAddCoursPlageHoraire.getSelectedItem().toString();

        int idLieux = getKeyByValue(mapLieux, jComboBoxAddCoursLieux.getSelectedItem());

        model.ModelCours.addCours(idCuisinier, idRecette, plageHoraire, idLieux);

    }//GEN-LAST:event_jButtonAddCoursActionPerformed

    /**
     * Déselectionne tous les champs
     * @param evt 
     */
    private void jCheckBoxNoOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxNoOneActionPerformed
        jCheckBoxAdmin.setSelected(false);
        jCheckBoxClient.setSelected(false);
        jCheckBoxCuisinier.setSelected(false);
        jCheckBoxAll.setSelected(false);
    }//GEN-LAST:event_jCheckBoxNoOneActionPerformed

    /**
     * Sélectionne tous les champs
     * @param evt 
     */
    private void jCheckBoxAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxAllActionPerformed
        jCheckBoxAdmin.setSelected(true);
        jCheckBoxClient.setSelected(true);
        jCheckBoxCuisinier.setSelected(true);
        jCheckBoxNoOne.setSelected(false);
    }//GEN-LAST:event_jCheckBoxAllActionPerformed

    /**
     * Permet d'afficher des utilisateurs précis dans le tableau
     * @param evt 
     */
    private void jButtonSearchUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchUsersActionPerformed
        String nom = jTextFieldSearchUsers.getText();
        String prenom = jTextField1.getText();

        ResultSet resultAllUsers = model.ModelUtilisateurs.selectParticularUsersWithConditions(nom, prenom, jCheckBoxClient.isSelected(), jCheckBoxCuisinier.isSelected(), jCheckBoxAdmin.isSelected());
        jTableUsers.setModel(DbUtils.resultSetToTableModel(resultAllUsers));
    }//GEN-LAST:event_jButtonSearchUsersActionPerformed

    private void jTextFieldAddAdminJourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAddAdminJourActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAddAdminJourActionPerformed

    /**
     * Ajoute un admin
     * @param evt 
     */
    private void jButtonAddAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddAdminActionPerformed
        String nom = jTextFieldAddAdminNom.getText();
        String prenom = jTextFieldAddAdminPrenom.getText();
        String password = new String(jPasswordFieldAddAdminPassword.getPassword());
        String passwordConfirm = new String(jPasswordFieldAddAdminPasswordConfirm.getPassword());
        String annee = jTextFieldAddAdminAnnee.getText();
        String mois = jTextFieldAddAdminMois.getText();
        String jour = jTextFieldAddAdminJour.getText();
        //String ville = (String)jComboBoxAddVilleUser.getSelectedItem();
        //String dateNaissance = jTextFieldAddAdminAnnee.getText() + "-" + jTextFieldAddAdminMois.getText()+ "-" + jTextFieldAddAdminJour.getText();

        System.out.println(password);

        Boolean userInBase = model.ModelUtilisateurs.verifyUser(nom, prenom);

        if (!nom.isEmpty() && !prenom.isEmpty()) {
            if (userInBase == false) {

                if (!annee.isEmpty() && !mois.isEmpty() && !jour.isEmpty()) {
                    if (password.equals(passwordConfirm)) {
                        int nbAnnee = Integer.parseInt(jTextFieldAddAdminAnnee.getText());
                        int nbMois = Integer.parseInt(jTextFieldAddAdminMois.getText());
                        int nbJour = Integer.parseInt(jTextFieldAddAdminJour.getText());

                        if (nbAnnee > 1900 && nbAnnee < 2020) {
                            if (nbMois > 0 && nbMois < 13) {
                                if (nbJour > 0 && nbJour < 32) {

                                    if (nbJour > 28 && nbMois == 2
                                        && ((nbAnnee % 4 != 0 || nbAnnee % 100 == 0))
                                        && nbAnnee % 400 != 0) {

                                        JOptionPane.showMessageDialog(this, "L'année sélectionnée n'est pas bisextile");

                                    } else {

                                        //Récupération des autres valeurs
                                        String ville = (String) jComboBoxAddVilleUser.getSelectedItem();
                                        String adresse = jTextFieldAddAdminAdresse.getText();
                                        String mail = jTextFieldAddAdminMail.getText();

                                        //Concaténation de la date
                                        String dateNaissance = annee + "-" + mois + "-" + jour;
                                        //Insertion
                                        model.ModelUtilisateurs.addUserAdmin(nom, prenom, dateNaissance, adresse, ville, password, mail);
                                    }

                                } else {
                                    JOptionPane.showMessageDialog(this, "Mauvais jour");
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Mauvais mois");
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Mauvaise année");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Les deux mots de passes ne correspondent pas !");
                    }
                } else {
                    model.ModelUtilisateurs.updateUserToAdmin(nom, prenom);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Le prénom et / ou le nom n'est pas renseigné");
            }
        }
    }//GEN-LAST:event_jButtonAddAdminActionPerformed

    /**
     * Permet d'ajouter une liste de ville dans une jComboBoxAddVilleUser en fonction de la chaîne de caractères présente dans je jTextFieldAddVilleUser
     * @param evt 
     */
    private void jTextFieldAddVilleUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAddVilleUserKeyPressed
        jComboBoxAddVilleUser.removeAllItems();
        int longueurChaine = jTextFieldAddVilleUser.getText().length();
        if (longueurChaine >= 3) {
            ArrayList result = model.ModelVille.selectVille(jTextFieldAddVilleUser.getText());

            for (int i = 0; i < result.size(); i++) {
                jComboBoxAddVilleUser.addItem((String) result.get(i));
            }
        }
    }//GEN-LAST:event_jTextFieldAddVilleUserKeyPressed

    private void jTextFieldAddVilleUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAddVilleUserActionPerformed

    }//GEN-LAST:event_jTextFieldAddVilleUserActionPerformed

    /**
     * Lie une catégorie avec un ingrédient
     * @param evt 
     */
    private void jTextFieldChooseCategorieIngredientKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldChooseCategorieIngredientKeyPressed
        // TODO add your handling code here:
        jComboBoxChooseCategorieIngredient.removeAllItems();
        int longueurChaine = jTextFieldChooseCategorieIngredient.getText().length();
        if (longueurChaine >= 3) {
            ArrayList result = model.ModelCategorie.selectCategorie(jTextFieldChooseCategorieIngredient.getText());

            for (int i = 0; i < result.size(); i++) {
                jComboBoxChooseCategorieIngredient.addItem((String) result.get(i));
            }
        }
    }//GEN-LAST:event_jTextFieldChooseCategorieIngredientKeyPressed

    private void jTextFieldChooseCategorieIngredientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldChooseCategorieIngredientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldChooseCategorieIngredientActionPerformed

    /**
     * Ajoute un ingrédient
     * @param evt 
     */
    private void jButtonAddIngredientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddIngredientActionPerformed
        // TODO add your handling code here:
        String categorie = (String)jComboBoxChooseCategorieIngredient.getSelectedItem();
        String nom = jTextFieldAddIngrédient.getText();
        String prix = jTextFieldPrixIngredient.getText();

        try{
            int prixInt = Integer.parseInt(prix);
            model.ModelIngredient.addIngredient(nom, categorie, prixInt);
        }catch(Exception e){
            System.out.println("Erreur lorsque l'on ajoute un ingrédient : "+e);
        }

        fillJTableIngredients();
    }//GEN-LAST:event_jButtonAddIngredientActionPerformed

    private void jButtonAddIngredientToRecetteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddIngredientToRecetteActionPerformed
        // TODO add your handling code here:
        String ingredientsInRecette = "";

        jLabelListIngredients.setText("");
        if(!arrayListIngredients.contains((String)jComboBoxListIngredients.getSelectedItem())){
            arrayListIngredients.add((String)jComboBoxListIngredients.getSelectedItem());
        }
        System.out.println(arrayListIngredients.size());

        for(int i = 0; i < arrayListIngredients.size(); i++){

            ingredientsInRecette += arrayListIngredients.get(i)+" , ";
        }

        jLabelListIngredients.setText(ingredientsInRecette);

    }//GEN-LAST:event_jButtonAddIngredientToRecetteActionPerformed

    private void jTextFieldListIngredientsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldListIngredientsKeyPressed
        // TODO add your handling code here:
        jComboBoxListIngredients.removeAllItems();
        ArrayList result = model.ModelIngredient.selectParticularIngredients(jTextFieldListIngredients.getText());

        for (int i = 0; i < result.size(); i++) {
            jComboBoxListIngredients.addItem((String) result.get(i));
        }
    }//GEN-LAST:event_jTextFieldListIngredientsKeyPressed

    private void jTextFieldListIngredientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldListIngredientsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldListIngredientsActionPerformed

    /**
     * Ajoute une recette
     * @param evt 
     */
    private void jButtonAddRecetteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddRecetteActionPerformed
        // TODO add your handling code here:
        String nom = jTextFieldAddRecette.getText();
        String description = jTextAreaAddRecette.getText();

        System.err.println(arrayListIngredients);

        model.ModelRecette.addRecette(nom, description);

        model.ModelRecette.addRecetteIngredients(nom, arrayListIngredients);
    }//GEN-LAST:event_jButtonAddRecetteActionPerformed

    private void jButtonDeleteCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteCategoryActionPerformed
        String nomCategory = jTextFieldAddCategory.getText();

        model.ModelCategorie.deleteCategory(nomCategory);

        fillJTableCategory();

        jTextAreaAddCategory.setText("");
        jTextFieldAddCategory.setText("");
    }//GEN-LAST:event_jButtonDeleteCategoryActionPerformed

    private void jButtonModifyCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifyCategoryActionPerformed
        String nomCategory = jTextFieldAddCategory.getText();
        String descriptionCategory = jTextAreaAddCategory.getText();

        model.ModelCategorie.updateCategory(nomCategory, descriptionCategory);

        fillJTableCategory();

        jTextAreaAddCategory.setText("");
        jTextFieldAddCategory.setText("");
    }//GEN-LAST:event_jButtonModifyCategoryActionPerformed

    /**
     * Affiche une catégorie précise dans le tableau
     * @param evt 
     */
    private void jButtonSearchCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchCategoryActionPerformed
        String searchCategory = jTextFieldSearchCategory.getText();

        ResultSet resultOneCategory = model.ModelCategorie.selectOneCategory(searchCategory);
        jTableCategory.setModel(DbUtils.resultSetToTableModel(resultOneCategory));
    }//GEN-LAST:event_jButtonSearchCategoryActionPerformed

    /**
     * Ajoute une catégorie, rafraichit le tableau et remets les champs vides
     * @param evt 
     */
    private void jButtonAddCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddCategoryActionPerformed
        String nomCategory = jTextFieldAddCategory.getText();
        String descriptionCategory = jTextAreaAddCategory.getText();

        model.ModelCategorie.createCategory(nomCategory, descriptionCategory);

        fillJTableCategory();

        jTextAreaAddCategory.setText("");
        jTextFieldAddCategory.setText("");
    }//GEN-LAST:event_jButtonAddCategoryActionPerformed

    private void jButtonModifyIngredientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifyIngredientActionPerformed
        
        String nom = jTextFieldAddIngrédient.getText();
        String prix = jTextFieldPrixIngredient.getText();
        String id = jTextFieldAddIngredientId.getText();

        try{
            int prixInt = Integer.parseInt(prix);
            int idIng = Integer.parseInt(id);
            model.ModelIngredient.modifyIngredient(idIng, nom, prixInt);
        }catch(Exception e){
            System.out.println("Erreur lorsque l'on modifie un ingrédient : "+e);
        }
        
        fillJTableIngredients();
    }//GEN-LAST:event_jButtonModifyIngredientActionPerformed

    private void jButtonDeleteIngredientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteIngredientActionPerformed
        String id = jTextFieldAddIngredientId.getText();

        try{
            int idIng = Integer.parseInt(id);
            model.ModelIngredient.deleteIngredient(idIng);
        }catch(Exception e){
            System.out.println("Erreur lorsque l'on modifie un ingrédient : "+e);
        }
        
        fillJTableIngredients();
    }//GEN-LAST:event_jButtonDeleteIngredientActionPerformed

    private void jButtonDeleteUtilisateursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteUtilisateursActionPerformed
        String id = jTextFieldDeleteUtilisateurs.getText();
        
        int idUser = Integer.parseInt(id);
        
        model.ModelUtilisateurs.deleteUtilisateur(idUser);
        
        fillJTableUsers();
    }//GEN-LAST:event_jButtonDeleteUtilisateursActionPerformed

    private void jButtonDeleteCoursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteCoursActionPerformed
        String id = jTextFieldCours.getText();
        
        int idCours = Integer.parseInt(id);
        
        model.ModelCours.deleteCours(idCours);
        
        fillJTableCours();
    }//GEN-LAST:event_jButtonDeleteCoursActionPerformed

    /**
     * Retourne la clé d'un élément d'une map en fonction de sa valeur
     * @param <T>
     * @param <E>
     * @param map
     * @param value
     * @return 
     */
    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
    for (Entry<T, E> entry : map.entrySet()) {
        if (Objects.equals(value, entry.getValue())) {
            return entry.getKey();
        }
    }
    return null;
}
    /**jComboBoxChooseIngredientItemStateChanged
     * 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonAddAdmin;
    private javax.swing.JButton jButtonAddCategory;
    private javax.swing.JButton jButtonAddCours;
    private javax.swing.JButton jButtonAddIngredient;
    private javax.swing.JButton jButtonAddIngredientToRecette;
    private javax.swing.JButton jButtonAddRecette;
    private javax.swing.JButton jButtonDeleteCategory;
    private javax.swing.JButton jButtonDeleteCours;
    private javax.swing.JButton jButtonDeleteIngredient;
    private javax.swing.JButton jButtonDeleteUtilisateurs;
    private javax.swing.JButton jButtonModifyCategory;
    private javax.swing.JButton jButtonModifyCours;
    private javax.swing.JButton jButtonModifyIngredient;
    private javax.swing.JButton jButtonSearchCategory;
    private javax.swing.JButton jButtonSearchUsers;
    private javax.swing.JCheckBox jCheckBoxAdmin;
    private javax.swing.JCheckBox jCheckBoxAll;
    private javax.swing.JCheckBox jCheckBoxClient;
    private javax.swing.JCheckBox jCheckBoxCuisinier;
    private javax.swing.JCheckBox jCheckBoxNoOne;
    private javax.swing.JComboBox<String> jComboBoxAddCoursCuisinier;
    private javax.swing.JComboBox<String> jComboBoxAddCoursLieux;
    private javax.swing.JComboBox<String> jComboBoxAddCoursPlageHoraire;
    private javax.swing.JComboBox<String> jComboBoxAddCoursRecette;
    private javax.swing.JComboBox<String> jComboBoxAddVilleUser;
    private javax.swing.JComboBox<String> jComboBoxChooseCategorieIngredient;
    private javax.swing.JComboBox<String> jComboBoxListIngredients;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAddAdminAdresse;
    private javax.swing.JLabel jLabelAddAdminDateNaissance;
    private javax.swing.JLabel jLabelAddAdminMail;
    private javax.swing.JLabel jLabelAddAdminNom;
    private javax.swing.JLabel jLabelAddAdminPassword;
    private javax.swing.JLabel jLabelAddAdminPasswordConfirm;
    private javax.swing.JLabel jLabelAddAdminPrenom;
    private javax.swing.JLabel jLabelChooseCategorieIngredient;
    private javax.swing.JLabel jLabelCuisinierInCours;
    private javax.swing.JLabel jLabelLieuxInCours;
    private javax.swing.JLabel jLabelListIngredients;
    private javax.swing.JLabel jLabelNomIngrédient;
    private javax.swing.JLabel jLabelPlageHoraireInCours;
    private javax.swing.JLabel jLabelPrixIngredient;
    private javax.swing.JLabel jLabelRecetteInCours;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPasswordField jPasswordFieldAddAdminPassword;
    private javax.swing.JPasswordField jPasswordFieldAddAdminPasswordConfirm;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPanelCours;
    private javax.swing.JTable jTableCategory;
    private javax.swing.JTable jTableCours;
    private javax.swing.JTable jTableIngredients;
    private javax.swing.JTable jTableRecettes;
    private javax.swing.JTable jTableUsers;
    private javax.swing.JTextArea jTextAreaAddCategory;
    private javax.swing.JTextArea jTextAreaAddRecette;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldAddAdminAdresse;
    private javax.swing.JTextField jTextFieldAddAdminAnnee;
    private javax.swing.JTextField jTextFieldAddAdminJour;
    private javax.swing.JTextField jTextFieldAddAdminMail;
    private javax.swing.JTextField jTextFieldAddAdminMois;
    private javax.swing.JTextField jTextFieldAddAdminNom;
    private javax.swing.JTextField jTextFieldAddAdminPrenom;
    private javax.swing.JTextField jTextFieldAddCategory;
    private javax.swing.JTextField jTextFieldAddIngredientId;
    private javax.swing.JTextField jTextFieldAddIngrédient;
    private javax.swing.JTextField jTextFieldAddRecette;
    private javax.swing.JTextField jTextFieldAddVilleUser;
    private javax.swing.JTextField jTextFieldChooseCategorieIngredient;
    private javax.swing.JTextField jTextFieldCours;
    private javax.swing.JTextField jTextFieldDeleteUtilisateurs;
    private javax.swing.JTextField jTextFieldListIngredients;
    private javax.swing.JTextField jTextFieldPrixIngredient;
    private javax.swing.JTextField jTextFieldSearchCategory;
    private javax.swing.JTextField jTextFieldSearchUsers;
    // End of variables declaration//GEN-END:variables
}
