/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.psnpsn.stocky.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author psnpsn
 */
@Entity
@Table(name="PRODUIT")
public class Produit {
    
    
    private int id;
    
    private String design;
    
    private String unite;
    
    private int qte;
    
    private float prix;
    
    private CategoriePrd cat;
    
    private Fournisseur fourn;
    
    private Magasin mag;

    public Produit() {
    }

    public Produit(String design, String unite, int qte, float prix, CategoriePrd cat, Fournisseur fourn, Magasin mag) {
        this.design = design;
        this.unite = unite;
        this.qte = qte;
        this.prix = prix;
        this.cat = cat;
        this.fourn = fourn;
        this.mag = mag;
    }

    @Id
    @Column(name="ID_P")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="designation")
    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    @Column(name="unite")
    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    @Column(name="quantite")
    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    @Column(name="prix")
    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_CAT", foreignKey=@ForeignKey(name="ID_CAT_FK"))
    public CategoriePrd getCat() {
        return cat;
    }

    public void setCat(CategoriePrd cat) {
        this.cat = cat;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_F", foreignKey=@ForeignKey(name="ID_F_FK"))
    public Fournisseur getFourn() {
        return fourn;
    }

    public void setFourn(Fournisseur fourn) {
        this.fourn = fourn;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_MAG", foreignKey=@ForeignKey(name="ID_MAG_FK"))
    public Magasin getMag() {
        return mag;
    }

    public void setMag(Magasin mag) {
        this.mag = mag;
    }
    
    
    
    
}
