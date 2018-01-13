/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.service;

import com.psnpsn.stocky.model.User;
import javafx.collections.ObservableList;

/**
 *
 * @author psnpsn
 */
public interface UserService {
    
    public boolean create(User F);
    
    public ObservableList<User> getAll();
    
    public User find(int id);
    
    public void delete(int id);
    
    public boolean update(User F);
    
    public User checkLogin(String login,char[] pwd);
    
}
