/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.utils;

import com.psnpsn.stocky.MainApp;
import com.psnpsn.stocky.model.User;
import com.psnpsn.stocky.model.UserProfile;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author psnpsn
 */
public class StageManager {
    
    private static StageManager stager = new StageManager();
    private User user;
    BorderPane root= MainApp.getRoot();
    
    private StageManager() {
    }
    
    public static StageManager getStageManager(){
        return stager;
    }
    
    public String getUsername(){
        return this.user.getLogin();
    }
    
    public int getRole(){
        return this.user.getRole();
    }
    
    public void setUser(User user){
        this.user=user;
    }
    
    public void Load(String s){
        try {
            URL content = getClass().getResource("/fxml/"+s+".fxml");
            AnchorPane middle = FXMLLoader.load(content);
            
            root.setCenter(middle);
           
        } catch (IOException ex) {
            Logger.getLogger(StageManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Dashboard(){
        try {    
            URL menu = getClass().getResource("/fxml/menuAdmin.fxml");
            AnchorPane left = FXMLLoader.load(menu);
            URL content = getClass().getResource("/fxml/produitList.fxml");
            AnchorPane middle = FXMLLoader.load(content);
            
            root.setCenter(middle);
            root.setLeft(left);
            
        } catch (IOException ex) {
            Logger.getLogger(StageManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LoginScreen(){
        try {    
            URL menu = getClass().getResource("/fxml/loginMenu.fxml");
            AnchorPane left = FXMLLoader.load(menu);
            URL content = getClass().getResource("/fxml/login.fxml");
            AnchorPane middle = FXMLLoader.load(content);
            
            root.setCenter(middle);
            root.setLeft(left);
            
        } catch (IOException ex) {
            Logger.getLogger(StageManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        user = null;
    }
}
