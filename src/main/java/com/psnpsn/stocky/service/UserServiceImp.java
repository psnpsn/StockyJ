/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.service;

import com.psnpsn.stocky.dao.UserDAO;
import com.psnpsn.stocky.model.User;
import com.psnpsn.stocky.model.User;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author psnpsn
 */
@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserDAO fournDao;

    @Transactional
    @Override
    public boolean create(User instance) {
        fournDao.create(instance);
        return true;
    }

    @Transactional (readOnly=true)
    @Override
    public ObservableList getAll() {
        return fournDao.getAll();
    }
    
    @Transactional
    @Override
    public void delete(int id) {
        fournDao.delete(id);
    }

    @Transactional
    @Override
    public boolean update(User instance) {
        fournDao.update(instance);
        return true;
    }

    @Transactional
    @Override
    public User find(int id) {
        return fournDao.find(id);
    }
}
