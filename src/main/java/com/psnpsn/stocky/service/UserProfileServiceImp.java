/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.service;

import com.psnpsn.stocky.dao.UserProfileDAO;
import com.psnpsn.stocky.model.UserProfile;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author psnpsn
 */
@Service
public class UserProfileServiceImp implements UserProfileService {

    @Autowired
    private UserProfileDAO usrPDao;

    @Transactional
    @Override
    public boolean create(UserProfile F) {
        usrPDao.create(F);
        return true;
    }

    @Transactional ( readOnly=true )
    @Override
    public ObservableList<UserProfile> getAll() {
        return usrPDao.getAll();
    }

    @Transactional
    @Override
    public UserProfile find(int id) {
        return usrPDao.find(id);
    }

    @Transactional
    @Override
    public void delete(int id) {
        usrPDao.delete(id);
    }

    @Transactional
    @Override
    public boolean update(UserProfile F) {
        usrPDao.update(F);
        return true;
    }
    
    
}
