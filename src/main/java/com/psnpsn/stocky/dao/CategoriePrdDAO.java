/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.dao;

import com.psnpsn.stocky.model.CategoriePrd;
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
public class CategoriePrdDAO implements GenericDAO<CategoriePrd> {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean create(CategoriePrd instance) {
        sessionFactory.getCurrentSession().save(instance);
        return true;
    }

    @Override
    public ObservableList<CategoriePrd> getAll() {
        @SuppressWarnings("unchecked")
        TypedQuery<CategoriePrd> query=sessionFactory.getCurrentSession().createQuery("from CategoriePrd");
        ObservableList<CategoriePrd> list = FXCollections.observableArrayList(query.getResultList());
      return list;
    }

    @Override
    public CategoriePrd find(Integer id) {
        @SuppressWarnings("unchecked")
        TypedQuery<CategoriePrd> query=sessionFactory.getCurrentSession().createQuery("from CategoriePrd where ID_CAT = :id");
        query.setParameter("id",id);
        CategoriePrd ctg = query.getSingleResult();
        return ctg;
    }

    @Override
    public void delete(Integer id) {
        @SuppressWarnings("unchecked")
        TypedQuery<CategoriePrd> query=sessionFactory.getCurrentSession().createQuery("DELETE from CategoriePrd WHERE ID_CAT = :id");
        query.setParameter("id",id);
        query.executeUpdate();
    }

    @Override
    public boolean update(CategoriePrd instance) {
         sessionFactory.getCurrentSession().saveOrUpdate(instance);
        return true;
    }
    
    
}
