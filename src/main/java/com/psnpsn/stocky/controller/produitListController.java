/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.psnpsn.stocky.model.Produit;
import com.psnpsn.stocky.service.ProduitService;
import com.psnpsn.stocky.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author psnpsn
 */
public class produitListController implements Initializable {
    
    ProduitService prodService = MainApp.context.getBean(ProduitService.class);
    
    private ObservableList<Produit> prodList = FXCollections.observableArrayList();

    @FXML
    private TableView<Produit> table;
    @FXML
    private TableColumn<Produit, String> designCol;
    @FXML
    private TableColumn<Produit, String> uniteCol;
    @FXML
    private TableColumn<Produit, Integer> qteCol;
    @FXML
    private TableColumn<Produit, Float> prixCol;
    @FXML
    private TableColumn<Produit, String> catCol;
    @FXML
    private TableColumn<Produit, String> fournCol;
    @FXML
    private TableColumn<Produit, String> magCol;
    @FXML
    private TableColumn<Produit, Boolean> editCol;
    @FXML
    private TableColumn<Produit, Boolean> suppCol;
    @FXML
    private JFXButton addBtn;
    @FXML
    private JFXTextField filterTxt;
    @FXML
    private AnchorPane windowBar;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            URL signIn = getClass().getResource("/fxml/windowbar.fxml");
            AnchorPane anchorpane = FXMLLoader.load(signIn);
            windowBar.getChildren().add(anchorpane);
        } catch (IOException ex) {
            Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        initCol();
        loadProduits();
    }
    
    
    // *Initializing Table View
    private void initCol(){
        // ** init table
        table.getSelectionModel().setCellSelectionEnabled(false);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        // ** init columns
        designCol.setCellValueFactory(new PropertyValueFactory("design"));
        uniteCol.setCellValueFactory(new PropertyValueFactory("unite"));
        qteCol.setCellValueFactory(new PropertyValueFactory("qte"));
        prixCol.setCellValueFactory(new PropertyValueFactory("prix"));
        catCol.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(""+cellData.getValue().getCat().getId());
        });
        fournCol.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(""+cellData.getValue().getFourn().getId());
        });
        magCol.setCellValueFactory(cellData -> {
            return new SimpleStringProperty(""+cellData.getValue().getMag().getId());
        });
        editCol.setCellValueFactory(new PropertyValueFactory<>("EDIT"));
        // ** setting the 'edit Product' button into the cell
        editCol.setCellFactory(fn_edit_produit ->
    new TableCell<Produit, Boolean>() {
            final JFXButton viewBtn = new JFXButton("");
            @Override
        public void updateItem(Boolean item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                Image img = new Image(getClass().getResourceAsStream("/images/edit.png"));
                
                ImageView iv = new ImageView();
                iv.setImage(img);
		iv.setPreserveRatio(true);
		iv.setSmooth(true);
                iv.setCache(true);
                iv.setFitHeight(20);
                iv.setFitWidth(20);
                
                viewBtn.setGraphic(iv);
                setGraphic(viewBtn);
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                setAlignment(Pos.CENTER);
                setText(null);
                // ** button action
                viewBtn.setOnAction(e -> {
                    Produit prod = getTableView().getItems().get(getIndex());
                    System.out.println(prod.getDesign());
                    
                });
            } 
            }
        });
        suppCol.setCellValueFactory(new PropertyValueFactory<>("DELETE"));
        // ** setting the 'delete product' button into the cell
        suppCol.setCellFactory(fn_delete_produit ->
    new TableCell<Produit, Boolean>() {
            final JFXButton viewBtn = new JFXButton();
            @Override
        public void updateItem(Boolean item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                Image img = new Image(getClass().getResourceAsStream("/images/delete.png"));
                
                ImageView iv = new ImageView();
                iv.setImage(img);
		iv.setPreserveRatio(true);
		iv.setSmooth(true);
                iv.setCache(true);
                iv.setFitHeight(20);
                iv.setFitWidth(20);
                
                viewBtn.setGraphic(iv);
                setGraphic(viewBtn);
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                setAlignment(Pos.CENTER);
                setText(null);
                // ** button action
                viewBtn.setOnAction(e -> {
                    Produit prod = getTableView().getItems().get(getIndex());
                    System.out.println("Deleting : Produit= "+prod.getDesign()+", ID= "+prod.getId());
                    prodService.delete(prod.getId());
                });
            } 
            }
        });
    }

    // Loading all products into Talbe View
    private void loadProduits() {
        prodList.clear();
        prodList = prodService.getAll();
        table.setItems(prodList);
    }
    
    
    
    
    
}
