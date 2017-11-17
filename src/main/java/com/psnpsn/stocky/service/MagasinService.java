/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.service;

import com.psnpsn.stocky.model.Magasin;
import javafx.collections.ObservableList;

/**
 *
 * @author psnpsn
 */
public interface MagasinService {
    
    public boolean create(Magasin F);
    
    public ObservableList<Magasin> getAll();
    
    public Magasin find(int id);
    
    public void delete(int id);
    
    public boolean update(Magasin F);
    
}
