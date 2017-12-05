/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.dao;

import com.psnpsn.stocky.model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.TypedQuery;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author psnpsn
 */
@Repository
public class UserDAO implements GenericDAO<User> {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean create(User instance) {
        
            sessionFactory.getCurrentSession().save(instance);
            return true;
       
    }

    @Override
    public ObservableList<User> getAll() {
        @SuppressWarnings("unchecked")
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from Users");
        ObservableList<User> list = FXCollections.observableArrayList(query.getResultList());
      return list;
    }

    @Override   
    public User find(Integer id) {
        @SuppressWarnings("unchecked")
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from Users where ID = :id");
        query.setParameter("id",id);
        User usr = query.getSingleResult();
        return usr;
    }

    @Override
    public void delete(Integer id) {
        @SuppressWarnings("unchecked")
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("DELETE from Users WHERE ID = :id");
        query.setParameter("id",id);
        query.executeUpdate();
        
        
    }

    @Override
    public boolean update(User instance) {
        sessionFactory.getCurrentSession().saveOrUpdate(instance);
        return true;
    }
    
    public int checkLogin(String login, char[] pwd){
        @SuppressWarnings("unchecked")
        TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User where LOGIN = :login AND PASSWORD = :pwd");
        query.setParameter("login",login);
        query.setParameter("pwd",pwd);
        ObservableList<User> list = FXCollections.observableArrayList(query.getResultList());
        if (list.isEmpty()){
            return -1;
        }else if (list.size()==1){
        return list.get(0).getAdmin();
        }
        return -2;
    }
            


}