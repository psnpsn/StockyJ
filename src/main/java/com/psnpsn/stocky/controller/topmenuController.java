/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.controller;

import com.psnpsn.stocky.MainApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author psnpsn
 */
public class topmenuController {

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
