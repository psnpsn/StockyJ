/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.service;

import com.psnpsn.stocky.model.Fournisseur;
import javafx.collections.ObservableList;

/**
 *
 * @author psnpsn
 * @param <T>
 */
public interface FournisseurService {
    
    public boolean create(Fournisseur F);
    
    public ObservableList<Fournisseur> getAll();
    
    public Fournisseur find(int id);
    
    public void delete(int id);
    
    public boolean update(Fournisseur F);
}
