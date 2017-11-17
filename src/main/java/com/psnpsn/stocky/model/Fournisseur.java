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
    
    @Id
    @Column(name="ID_F")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    
    @Column(name="NOM_F")
    private String nom;
    
    
    @Column(name="ADR_F")
    private String adr;
    
    @Column(name="CODEP_F")
    private Integer codeP;
    
    @Column(name="VILLE_F")
    private String ville;
    
    @Column(name="PAYS_F")
    private String pays;
    
    @Column(name="TEL_F")
    private Integer tel;
    
    @Column(name="FAX_F")
    private Integer fax;
    
    @Column(name="EMAIL_F")
    private String email;
    
    public Fournisseur(){
        
    }

    public Fournisseur(String nom, String adr, Integer codeP, String ville, String pays, Integer tel, Integer fax, String email) {
        this.nom = nom;
        this.adr = adr;
        this.codeP = codeP;
        this.ville = ville;
        this.pays = pays;
        this.tel = tel;
        this.fax = fax;
        this.email = email;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer num) {
        this.id = num;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public Integer getCodeP() {
        return codeP;
    }

    public void setCodeP(Integer codeP) {
        this.codeP = codeP;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Integer getTel() {
        return tel;
    }

    public void setTel(Integer tel) {
        this.tel = tel;
    }

    public Integer getFax() {
        return fax;
    }

    public void setFax(Integer fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
