package com.psnpsn.stocky.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.psnpsn.stocky.MainApp;
import com.psnpsn.stocky.service.UserService;
import com.psnpsn.stocky.utils.StageManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;

public class loginController implements Initializable {

    @FXML
    private JFXTextField usrTxt;

    @FXML
    private JFXPasswordField pwTxt;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private Label errorMsg;
    
    UserService usrService = MainApp.context.getBean(UserService.class);
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

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

    @FXML
    void seConnecter(ActionEvent event) {
        String login = usrTxt.getText();
        char[] password = pwTxt.getText().toCharArray();
        
        if(usrService.checkLogin(login, password)>=0){
            MainApp.stager.Load("dashboard");
        }
        else{
            System.out.println("USER DOESNT EXIST");
        }
        

    }

    

}
