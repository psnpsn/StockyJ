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
@Table(name="MAGASIN")
public class Magasin {
    
    @Id
    @Column(name="ID_MAG")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @Column(name="NOM_MAG")
    private String nom;
    
    @Column(name="ADR_MAG")
    private String addr;

    public Magasin() {
    }

    public Magasin(String nom, String addr) {
        this.nom = nom;
        this.addr = addr;
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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
    
    
}
