/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.dao;

import com.psnpsn.stocky.model.Produit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

/**
 *
 * @author psnpsn
 */

@Repository
public class ProduitDAO implements GenericDAO<Produit> {
    
    @PersistenceContext
   private EntityManager em;


    @Override
    public boolean create(Produit instance) {
        em.persist(instance);
        return true;
    }

    @Override
    public ObservableList<Produit> getAll() {
        CriteriaQuery<Produit> criteriaQuery = em.getCriteriaBuilder().createQuery(Produit.class);
      @SuppressWarnings("unused")
      Root<Produit> root = criteriaQuery.from(Produit.class);
      ObservableList<Produit> list = FXCollections.observableArrayList(em.createQuery(criteriaQuery).getResultList());
      return list;
    }

    @Override   
    public Produit find(Integer id) {
        return em.find(Produit.class, id);
    }

    @Override
    public void delete(Integer id) {
        em.remove(id);
    }

    @Override
    public boolean update(Produit instance) {
        em.merge(instance);
        return true;
    }
    
}
