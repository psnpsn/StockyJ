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
    
    @Id
    @Column(name="ID_P")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    @Column(name="designation")
    private String design;
    
    @Column(name="unite")
    private String unite;
    
    @Column(name="quantite")
    private int qte;
    
    @Column(name="prix")
    private float prix;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_CAT", foreignKey=@ForeignKey(name="ID_CAT_FK"))
    private CategoriePrd cat;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_F", foreignKey=@ForeignKey(name="ID_F_FK"))
    private Fournisseur fourn;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ID_MAG", foreignKey=@ForeignKey(name="ID_MAG_FK"))
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public CategoriePrd getCat() {
        return cat;
    }

    public void setCat(CategoriePrd cat) {
        this.cat = cat;
    }

    public Fournisseur getFourn() {
        return fourn;
    }

    public void setFourn(Fournisseur fourn) {
        this.fourn = fourn;
    }

    public Magasin getMag() {
        return mag;
    }

    public void setMag(Magasin mag) {
        this.mag = mag;
    }
    
    
    
    
}
