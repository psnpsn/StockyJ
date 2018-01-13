/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.dao;

import com.psnpsn.stocky.model.CategoriePrd;
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
public class CategoriePrdDAO implements GenericDAO<CategoriePrd> {
    
    @PersistenceContext
   private EntityManager em;


    @Override
    public boolean create(CategoriePrd instance) {
        em.persist(instance);
        return true;
    }

    @Override
    public ObservableList<CategoriePrd> getAll() {
        CriteriaQuery<CategoriePrd> criteriaQuery = em.getCriteriaBuilder().createQuery(CategoriePrd.class);
      @SuppressWarnings("unused")
      Root<CategoriePrd> root = criteriaQuery.from(CategoriePrd.class);
      ObservableList<CategoriePrd> list = FXCollections.observableArrayList(em.createQuery(criteriaQuery).getResultList());
      return list;
    }

    @Override   
    public CategoriePrd find(Integer id) {
        return em.find(CategoriePrd.class, id);
    }

    @Override
    public void delete(Integer id) {
        em.remove(id);
    }

    @Override
    public boolean update(CategoriePrd instance) {
        em.merge(instance);
        return true;
    }
    
}
