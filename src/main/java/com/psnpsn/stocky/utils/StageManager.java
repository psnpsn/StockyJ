/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.utils;

import com.psnpsn.stocky.MainApp;
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
    
    private static UserProfile user;
    
    
    
    public UserProfile getUser(){
        return StageManager.user;
    }
    
    public void setUser(UserProfile user){
        StageManager.user=user;
    }
    
    public void Load(String s){
        try {
            BorderPane root= MainApp.getRoot();
            
            URL top = getClass().getResource("/fxml/topmenu.fxml");
            VBox topmenu = FXMLLoader.load(top);
            
            URL content = getClass().getResource("/fxml/"+s+".fxml");
            AnchorPane middle = FXMLLoader.load(content);
            
            root.setCenter(middle);
            root.setTop(topmenu);
            
        } catch (IOException ex) {
            Logger.getLogger(StageManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Dashboard(){
        BorderPane root= MainApp.getRoot();
        try {    
            URL top = getClass().getResource("/fxml/topmenu.fxml");
            VBox topmenu;
       
            topmenu = FXMLLoader.load(top);
            URL content = getClass().getResource("/fxml/produitList.fxml");
            AnchorPane middle = FXMLLoader.load(content);
            
            root.setCenter(middle);
            root.setTop(topmenu);
            
        } catch (IOException ex) {
            Logger.getLogger(StageManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void LoginScreen(){
        
    }
}
