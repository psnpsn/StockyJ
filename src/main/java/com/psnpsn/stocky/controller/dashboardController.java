/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.controller;

import com.psnpsn.stocky.MainApp;
import com.psnpsn.stocky.utils.StageManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 *
 * @author psnpsn
 */
public class dashboardController {

    @FXML
    private void profiles(ActionEvent event) {
        
    }

    @FXML
    private void produits(ActionEvent event) {
        StageManager.getStageManager().Load("produitList");
    }

    @FXML
    private void fournisseurs(ActionEvent event) {
    }
    
}
