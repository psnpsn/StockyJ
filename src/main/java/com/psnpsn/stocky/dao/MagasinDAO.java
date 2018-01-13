/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.dao;

import com.psnpsn.stocky.model.Magasin;
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
public class MagasinDAO implements GenericDAO<Magasin> {
    
    @PersistenceContext
   private EntityManager em;


    @Override
    public boolean create(Magasin instance) {
        em.persist(instance);
        return true;
    }

    @Override
    public ObservableList<Magasin> getAll() {
        CriteriaQuery<Magasin> criteriaQuery = em.getCriteriaBuilder().createQuery(Magasin.class);
      @SuppressWarnings("unused")
      Root<Magasin> root = criteriaQuery.from(Magasin.class);
      ObservableList<Magasin> list = FXCollections.observableArrayList(em.createQuery(criteriaQuery).getResultList());
      return list;
    }

    @Override   
    public Magasin find(Integer id) {
        return em.find(Magasin.class, id);
    }

    @Override
    public void delete(Integer id) {
        em.remove(id);
    }

    @Override
    public boolean update(Magasin instance) {
        em.merge(instance);
        return true;
    }
    
}
