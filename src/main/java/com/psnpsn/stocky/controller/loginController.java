package com.psnpsn.stocky.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.psnpsn.stocky.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class loginController {

    @FXML
    private JFXTextField usrTxt;

    @FXML
    private JFXPasswordField pwTxt;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private Label errorMsg;

    @FXML
    void closeApp(ActionEvent event) {

    }

    @FXML
    void dragged(MouseEvent event) {

    }

    @FXML
    void minimizeApp(ActionEvent event) {

    }

    @FXML
    void pressed(MouseEvent event) {

    }

    @FXML
    void seConnecter(ActionEvent event) {
        try {
            BorderPane root= MainApp.getRoot();
            
            URL top = getClass().getResource("/fxml/topmenu.fxml");
            VBox topmenu = FXMLLoader.load(top);
            
            URL admin = getClass().getResource("/fxml/adminMenu.fxml");
            VBox adminMenu = FXMLLoader.load(admin);
            
            URL content = getClass().getResource("/fxml/dashboard.fxml");
            AnchorPane middle = FXMLLoader.load(content);
            
            root.setCenter(middle);
            root.setTop(topmenu);
            root.setLeft(adminMenu);
        } catch (IOException ex) {
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
