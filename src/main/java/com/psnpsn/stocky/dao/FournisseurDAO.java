/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.dao;

import com.psnpsn.stocky.model.Fournisseur;
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
public class FournisseurDAO implements GenericDAO<Fournisseur> {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean create(Fournisseur instance) {
        sessionFactory.getCurrentSession().save(instance);
        return true;
    }

    @Override
    public ObservableList<Fournisseur> getAll() {
        @SuppressWarnings("unchecked")
        TypedQuery<Fournisseur> query=sessionFactory.getCurrentSession().createQuery("from Fournisseur");
        ObservableList<Fournisseur> list = FXCollections.observableArrayList(query.getResultList());
      return list;
    }

    @Override   
    public Fournisseur find(Integer id) {
        @SuppressWarnings("unchecked")
        TypedQuery<Fournisseur> query=sessionFactory.getCurrentSession().createQuery("from Fournisseur f where ID_F = :id");
        query.setParameter("id",id);
        Fournisseur fourn = query.getSingleResult();
        return fourn;
    }

    @Override
    public void delete(Integer id) {
        @SuppressWarnings("unchecked")
        TypedQuery<Fournisseur> query=sessionFactory.getCurrentSession().createQuery("DELETE from Fournisseur WHERE ID_F = :id");
        query.setParameter("id",id);
        query.executeUpdate();
        
        
    }

    @Override
    public boolean update(Fournisseur instance) {
        sessionFactory.getCurrentSession().saveOrUpdate(instance);
        return true;
    }
    
}
