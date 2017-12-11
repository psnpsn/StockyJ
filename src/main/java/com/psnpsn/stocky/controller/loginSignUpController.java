/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.psnpsn.stocky.MainApp;
import com.psnpsn.stocky.model.User;
import com.psnpsn.stocky.model.UserProfile;
import com.psnpsn.stocky.service.UserProfileService;
import com.psnpsn.stocky.service.UserService;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author psnpsn
 */
public class loginSignUpController {

    @FXML
    private AnchorPane anchor;
    
    UserService userService = MainApp.context.getBean(UserService.class);
    UserProfileService userProfileService = MainApp.context.getBean(UserProfileService.class);
    @FXML
    private JFXTextField loginTxt;
    @FXML
    private JFXTextField nomTxt;
    @FXML
    private JFXTextField prenomTxt;
    @FXML
    private JFXPasswordField mdpTxt;
    @FXML
    private JFXPasswordField repmdpTxt;
    @FXML
    private JFXTextField emailTxt;

    @FXML
    private void confirmer(ActionEvent event) {
        
        if (validate()){
            // Get the user information from the textfields
            String login = loginTxt.getText().trim();
            String nom = nomTxt.getText().trim();
            String prenom = prenomTxt.getText().trim();
            String email = emailTxt.getText().trim();
            char[] mdp = mdpTxt.getText().trim().toCharArray();
            char[] repmdp = repmdpTxt.getText().trim().toCharArray();

            // Create User with informations
            User user = new User(login,mdp,0);

            //  Create User Profile with informations
            UserProfile userProfile = new UserProfile();
            userProfile.setNom(nom);
            userProfile.setPrenom(prenom);
            userProfile.setEmail(email);
            userProfile.setCreatedOn(LocalDateTime.now());
            userProfile.setLastLogin(LocalDateTime.now());
            userProfile.setUser(user);
            
            userService.create(user);
            userProfileService.create(userProfile);
        }
        
    }

    @FXML
    private void backLogin(ActionEvent event) {
        try {
            URL signIn = getClass().getResource("/fxml/loginSignIn.fxml");
            AnchorPane anchorpane = FXMLLoader.load(signIn);
            
            anchor.getChildren().clear();
            anchor.getChildren().add(anchorpane);
        } catch (IOException ex) {
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean validate(){
        if (loginTxt.getText().trim().isEmpty()){
            loginTxt.getStyleClass().add("validateTxt");
            return false;
        }
        if (mdpTxt.getText().trim().isEmpty()){
            mdpTxt.getStyleClass().add("validateTxt");
            return false;
        }
        if (mdpTxt.getText().trim().compareTo(repmdpTxt.getText().trim())!=0){
            repmdpTxt.getStyleClass().add("validateTxt");
            return false;
        }
        
        
        
        return true;
    }
    
}
