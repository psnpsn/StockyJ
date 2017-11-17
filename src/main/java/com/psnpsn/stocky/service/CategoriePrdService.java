/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.service;

import com.psnpsn.stocky.model.CategoriePrd;
import javafx.collections.ObservableList;

/**
 *
 * @author psnpsn
 */
public interface CategoriePrdService {
    
    public boolean create(CategoriePrd F);
    
    public ObservableList<CategoriePrd> getAll();
    
    public CategoriePrd find(int id);
    
    public void delete(int id);
    
    public boolean update(CategoriePrd F);
    
}
