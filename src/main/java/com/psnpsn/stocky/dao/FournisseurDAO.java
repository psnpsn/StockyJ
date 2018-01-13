/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.dao;

import com.psnpsn.stocky.model.Fournisseur;
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
public class FournisseurDAO implements GenericDAO<Fournisseur> {
    
    @PersistenceContext
   private EntityManager em;


    @Override
    public boolean create(Fournisseur instance) {
        em.persist(instance);
        return true;
    }

    @Override
    public ObservableList<Fournisseur> getAll() {
        CriteriaQuery<Fournisseur> criteriaQuery = em.getCriteriaBuilder().createQuery(Fournisseur.class);
      @SuppressWarnings("unused")
      Root<Fournisseur> root = criteriaQuery.from(Fournisseur.class);
      ObservableList<Fournisseur> list = FXCollections.observableArrayList(em.createQuery(criteriaQuery).getResultList());
      return list;
    }

    @Override   
    public Fournisseur find(Integer id) {
        return em.find(Fournisseur.class, id);
    }

    @Override
    public void delete(Integer id) {
        em.remove(id);
    }

    @Override
    public boolean update(Fournisseur instance) {
        em.merge(instance);
        return true;
    }
    
}
