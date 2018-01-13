/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.dao;

import com.psnpsn.stocky.model.UserProfile;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author psnpsn
 */

@Repository
public class UserProfileDAO implements GenericDAO<UserProfile> {
    
    @PersistenceContext
   private EntityManager em;


    @Override
    public boolean create(UserProfile instance) {
        em.persist(instance);
        return true;
    }

    @Override
    public ObservableList<UserProfile> getAll() {
        CriteriaQuery<UserProfile> criteriaQuery = em.getCriteriaBuilder().createQuery(UserProfile.class);
      @SuppressWarnings("unused")
      Root<UserProfile> root = criteriaQuery.from(UserProfile.class);
      ObservableList<UserProfile> list = FXCollections.observableArrayList(em.createQuery(criteriaQuery).getResultList());
      return list;
    }

    @Override   
    public UserProfile find(Integer id) {
        return em.find(UserProfile.class, id);
    }

    @Override
    public void delete(Integer id) {
        em.remove(id);
    }

    @Override
    public boolean update(UserProfile instance) {
        em.merge(instance);
        return true;
    }
    
}
