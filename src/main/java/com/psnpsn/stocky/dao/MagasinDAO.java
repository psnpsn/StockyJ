/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.dao;

import com.psnpsn.stocky.model.Magasin;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author psnpsn
 */
@Repository
public class MagasinDAO implements GenericDAO<Magasin> {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean create(Magasin instance) {
        sessionFactory.getCurrentSession().save(instance);
        return true;
    }

    @Override
    public ObservableList<Magasin> getAll() {
        @SuppressWarnings("unchecked")
        TypedQuery<Magasin> query=sessionFactory.getCurrentSession().createQuery("from Magasin");
        ObservableList<Magasin> list = FXCollections.observableArrayList(query.getResultList());
      return list;
    }

    @Override
    public Magasin find(Integer id) {
        @SuppressWarnings("unchecked")
        TypedQuery<Magasin> query=sessionFactory.getCurrentSession().createQuery("from Magasin where ID_MAG = :id");
        query.setParameter("id",id);
        Magasin mag = query.getSingleResult();
        return mag;
    }

    @Override
    public void delete(Integer id) {
        @SuppressWarnings("unchecked")
        TypedQuery<Magasin> query=sessionFactory.getCurrentSession().createQuery("DELETE from Magasin WHERE ID_MAG = :id");
        query.setParameter("id",id);
        query.executeUpdate();
    }

    @Override
    public boolean update(Magasin instance) {
         sessionFactory.getCurrentSession().saveOrUpdate(instance);
        return true;
    }
    
}
