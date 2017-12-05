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
    private UserDAO usrDao;

    @Transactional
    @Override
    public boolean create(User instance) {
        usrDao.create(instance);
        return true;
    }

    @Transactional (readOnly=true)
    @Override
    public ObservableList getAll() {
        return usrDao.getAll();
    }
    
    @Transactional
    @Override
    public void delete(int id) {
        usrDao.delete(id);
    }

    @Transactional
    @Override
    public boolean update(User instance) {
        usrDao.update(instance);
        return true;
    }

    @Transactional
    @Override
    public User find(int id) {
        return usrDao.find(id);
    }

    @Transactional
    @Override
    public int checkLogin(String login, char[] pwd) {
        return usrDao.checkLogin(login, pwd);
    }
}
