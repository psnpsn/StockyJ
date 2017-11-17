/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.dao;

import com.psnpsn.stocky.model.Produit;
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
public class ProduitDAO implements GenericDAO<Produit> {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean create(Produit instance) {
        sessionFactory.getCurrentSession().save(instance);
        return true;
    }

    @Override
    public ObservableList<Produit> getAll() {
        @SuppressWarnings("unchecked")
        TypedQuery<Produit> query=sessionFactory.getCurrentSession().createQuery("from Produit");
        ObservableList<Produit> list = FXCollections.observableArrayList(query.getResultList());
      return list;
    }

    @Override
    public Produit find(Integer id) {
        @SuppressWarnings("unchecked")
        TypedQuery<Produit> query=sessionFactory.getCurrentSession().createQuery("from Produit where ID_P = :id");
        query.setParameter("id",id);
        Produit prod = query.getSingleResult();
        return prod;
    }

    @Override
    public void delete(Integer id) {
        @SuppressWarnings("unchecked")
        TypedQuery<Produit> query=sessionFactory.getCurrentSession().createQuery("DELETE from Produit WHERE ID_P = :id");
        query.setParameter("id",id);
        query.executeUpdate();
    }

    @Override
    public boolean update(Produit instance) {
         sessionFactory.getCurrentSession().saveOrUpdate(instance);
        return true;
    }
    
    
}
