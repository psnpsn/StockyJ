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
@Table(name="FOURNISSEUR")
public class Fournisseur {
    
    private int id;
    
    
    private String nom;
    
    
    private String adr;
    
    private int codeP;
    
    private String ville;
    
    private String pays;
    
    private int tel;
    
    private int fax;
    
    private String email;
    
    public Fournisseur(){
        
    }

    public Fournisseur(String nom, String adr, int codeP, String ville, String pays, int tel, int fax, String email) {
        this.nom = nom;
        this.adr = adr;
        this.codeP = codeP;
        this.ville = ville;
        this.pays = pays;
        this.tel = tel;
        this.fax = fax;
        this.email = email;
    }
    
    
    @Id
    @Column(name="ID_F")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int num) {
        this.id = num;
    }

    @Column(name="NOM_F")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Column(name="ADR_F")
    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    @Column(name="CODEP_F")
    public int getCodeP() {
        return codeP;
    }

    public void setCodeP(int codeP) {
        this.codeP = codeP;
    }

    @Column(name="VILLE_F")
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Column(name="PAYS_F")
    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Column(name="TEL_F")
    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    @Column(name="FAX_F")
    public int getFax() {
        return fax;
    }

    public void setFax(int fax) {
        this.fax = fax;
    }

    @Column(name="EMAIL_F")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
