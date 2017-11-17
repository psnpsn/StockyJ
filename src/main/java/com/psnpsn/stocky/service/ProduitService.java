/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.service;

import com.psnpsn.stocky.model.Produit;
import javafx.collections.ObservableList;

/**
 *
 * @author psnpsn
 */
public interface ProduitService {
    
    public boolean create(Produit F);
    
    public ObservableList<Produit> getAll();
    
    public Produit find(int id);
    
    public void delete(int id);
    
    public boolean update(Produit F);
    
}
