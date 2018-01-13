/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author psnpsn
 */
public class loginMenuController implements Initializable {

    @FXML
    private AnchorPane anchor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            URL signIn = getClass().getResource("/fxml/loginSignIn.fxml");
            AnchorPane anchorpane = FXMLLoader.load(signIn);
            anchor.getChildren().add(anchorpane);
        } catch (IOException ex) {
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
