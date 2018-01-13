/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author psnpsn
 */
public class AjoutProduitController implements Initializable {

    @FXML
    private AnchorPane root;
    @FXML
    private JFXTextField designTF;
    @FXML
    private JFXTextField unitTF;
    @FXML
    private JFXTextField qteTF;
    @FXML
    private JFXTextField prixTF;
    @FXML
    private JFXTextField catTF;
    @FXML
    private JFXTextField fournTF;
    @FXML
    private JFXTextField magTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
    }

    @FXML
    private void annuler(ActionEvent event) {
        Stage stage = (Stage) root.getScene().getWindow();
        stage.close();
    }
    
}
