/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.dao;

import com.psnpsn.stocky.model.Fournisseur;
import javafx.collections.ObservableList;

/**
 *
 * @author psnpsn
 */


public interface GenericDAO<T> {
    
    public boolean create(T instance);
    
    public ObservableList<T> getAll();
    
    public T find(Integer id);
    
    public void delete(Integer id);
    
    public boolean update(T instance);
    
   
    
}
