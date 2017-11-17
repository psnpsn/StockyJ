/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author psnpsn
 */
@Entity
@Table(name="CATEGORIE_PRODUIT")
public class CategoriePrd {
    
    @Id
    @Column(name="ID_CAT")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @Column(name="NOM_CAT")
    private String nom;
    
    @Column(name="DESCRIPTION")
    private String desc;

    public CategoriePrd() {
    }

    public CategoriePrd(String nom, String desc) {
        this.nom = nom;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    
    
}
