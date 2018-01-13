/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.dao;

import com.psnpsn.stocky.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
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
public class UserDAO implements GenericDAO<User> {
    
    @PersistenceContext
   private EntityManager em;


    @Override
    public boolean create(User instance) {
        em.persist(instance);
        return true;
    }

    @Override
    public ObservableList<User> getAll() {
      CriteriaQuery<User> criteriaQuery = em.getCriteriaBuilder().createQuery(User.class);
      @SuppressWarnings("unused")
      Root<User> root = criteriaQuery.from(User.class);
      ObservableList<User> list = FXCollections.observableArrayList(em.createQuery(criteriaQuery).getResultList());
      return list;
    }

    @Override   
    public User find(Integer id) {
        return em.find(User.class, id);
    }

    @Override
    public void delete(Integer id) {
        em.remove(id);
    }

    @Override
    public boolean update(User instance) {
        em.merge(instance);
        return true;
    }
    
  
    public User checkLogin(String login, char[] pwd){
      CriteriaBuilder builder = em.getCriteriaBuilder();  
      CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
      Root<User> root = criteriaQuery.from(User.class);
      criteriaQuery.select(root).where(builder.equal(root.get("login"),login),builder.equal(root.get("pwd"),pwd));
      ObservableList<User> list = FXCollections.observableArrayList(em.createQuery(criteriaQuery).getResultList());
        if (list.isEmpty()){
            return null;
        }else 
        return list.get(0);
        
    }
            


}