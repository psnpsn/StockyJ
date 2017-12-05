/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.dao;

import com.psnpsn.stocky.model.UserProfile;
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
public class UserProfileDAO implements GenericDAO<UserProfile> {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean create(UserProfile instance) {
        sessionFactory.getCurrentSession().save(instance);
            return true;
    }

    @Override
    public ObservableList<UserProfile> getAll() {
        @SuppressWarnings("unchecked")
        TypedQuery<UserProfile> query=sessionFactory.getCurrentSession().createQuery("from Users");
        ObservableList<UserProfile> list = FXCollections.observableArrayList(query.getResultList());
      return list;
    }

    @Override
    public UserProfile find(Integer id) {
        @SuppressWarnings("unchecked")
        TypedQuery<UserProfile> query=sessionFactory.getCurrentSession().createQuery("from Users where ID = :id");
        query.setParameter("id",id);
        UserProfile usr = query.getSingleResult();
        return usr;
    }

    @Override
    public void delete(Integer id) {
         @SuppressWarnings("unchecked")
        TypedQuery<UserProfile> query=sessionFactory.getCurrentSession().createQuery("DELETE from Users WHERE ID = :id");
        query.setParameter("id",id);
        query.executeUpdate();
    }

    @Override
    public boolean update(UserProfile instance) {
        sessionFactory.getCurrentSession().saveOrUpdate(instance);
        return true;
    }
    
}
