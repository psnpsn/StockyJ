package com.psnpsn.stocky.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.psnpsn.stocky.MainApp;
import com.psnpsn.stocky.service.UserService;
import com.psnpsn.stocky.utils.StageManager;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Polygon;
import org.springframework.beans.factory.annotation.Autowired;

public class loginController {

    @FXML
    private Polygon poly;
    @FXML
    private AnchorPane anchor;
    
    @FXML
    void closeApp(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void dragged(MouseEvent event) {
        MainApp.stage.setX(event.getScreenX() - MainApp.xOffset);
        MainApp.stage.setY(event.getScreenY() - MainApp.yOffset);

    }

    @FXML
    void minimizeApp(ActionEvent event) {
        MainApp.stage.setIconified(true);
    }

    @FXML
    void pressed(MouseEvent event) {
        MainApp.xOffset=event.getSceneX();
        MainApp.yOffset=event.getSceneY();

    }

}
