/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.service;


import com.psnpsn.stocky.model.UserProfile;
import javafx.collections.ObservableList;

/**
 *
 * @author psnpsn
 */
public interface UserProfileService {
    public boolean create(UserProfile F);
    
    public ObservableList<UserProfile> getAll();
    
    public UserProfile find(int id);
    
    public void delete(int id);
    
    public boolean update(UserProfile F);
    
}
