/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.controller;

import com.jfoenix.controls.JFXButton;
import com.psnpsn.stocky.utils.StageManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 *
 * @author psnpsn
 */
public class menuAdminController implements Initializable {

    @FXML
    private JFXButton dashBtn;
    @FXML
    private JFXButton prodBtn;
    @FXML
    private JFXButton magBtn;
    @FXML
    private JFXButton catBtn;
    @FXML
    private JFXButton userBtn;
    @FXML
    private ImageView userImage;
    @FXML
    private Label usernameLabel;
    @FXML
    private JFXButton profileBtn;
    @FXML
    private JFXButton logoutBtn;

     StageManager stager = StageManager.getStageManager();

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usernameLabel.setText("Bienvenue "+stager.getUsername());
    }    

    @FXML
    private void goDashboard(ActionEvent event) {
    }

    @FXML
    private void goProduits(ActionEvent event) {
    }

    @FXML
    private void goFournisseurs(ActionEvent event) {
    }

    @FXML
    private void goMagasins(ActionEvent event) {
    }

    @FXML
    private void goCategories(ActionEvent event) {
    }

    @FXML
    private void goUsers(ActionEvent event) {
    }

    @FXML
    private void goProfile(ActionEvent event) {
    }

    @FXML
    private void disconnect(ActionEvent event) {
    }
    
}
