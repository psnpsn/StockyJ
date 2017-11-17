/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.service;

import com.psnpsn.stocky.dao.FournisseurDAO;
import com.psnpsn.stocky.model.Fournisseur;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FournisseurServiceImp implements FournisseurService {
    
    @Autowired
    private FournisseurDAO fournDao;

    @Transactional
    @Override
    public boolean create(Fournisseur instance) {
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
    public boolean update(Fournisseur F) {
        fournDao.update(F);
        return true;
    }

    @Transactional
    @Override
    public Fournisseur find(int id) {
        return fournDao.find(id);
    }
}
